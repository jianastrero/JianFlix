package com.jianastrero.movie_data

import com.jianastrero.constant.NetworkConstants.CACHE_TIMEOUT
import com.jianastrero.movie_data.local.MovieDao
import com.jianastrero.movie_data.local.model.toMovie
import com.jianastrero.movie_data.local.model.toMovieEntity
import com.jianastrero.movie_data.remote.ITunesApi
import com.jianastrero.movie_data.remote.model.toMovie
import com.jianastrero.movie_domain.MovieRepository
import com.jianastrero.movie_domain.model.Movie

/**
 * Implementation of MovieRepository
 *
 * @param iTunesApi Remote Datasource for Movies
 * @param movieDao Local Datasource for Movies
 *
 * @constructor Create an Instance of MovieRepository
 *
 * @author Jian James P. Astrero
 */
class MovieRepositoryImpl(
    private val iTunesApi: ITunesApi,
    private val movieDao: MovieDao
) : MovieRepository {

    private var lastFetch = 0L

    /**
     * Get All Movie Domains
     *
     * @author Jian James P. Astrero
     */
    override suspend fun getAll(): List<Movie> {
        updateLocal()

        return movieDao
            .getAll() // Get all MovieEntities from Local Database
            .map { it.toMovie() } // Map MovieEntities to Movie Domains
    }

    /**
     * Get Movie Domain by ID
     *
     * @param id The id of the Movie to be fetched
     *
     * @author Jian James P. Astrero
     */
    override suspend fun getById(id: Int): Movie =
        movieDao
            .getById(id) // Get MovieEntity by ID
            .toMovie() // Convert MovieEntity to Movie Domain

    override suspend fun update(movie: Movie): Movie {
        val movieEntity = movie.toMovieEntity()
        movieDao.update(movieEntity)
        val updatedMovieEntity = movieDao.getById(movieEntity.id)
        return updatedMovieEntity.toMovie()
    }

    override suspend fun getMoviesByGenre(genre: String): List<Movie> {
        updateLocal()

        return movieDao
            .getAll() // Get all MovieEntities from Local Database
            .mapNotNull {
                if (it.genre == genre) it.toMovie() else null
            } // Map MovieEntities to Movie Domains
    }

    private suspend fun updateLocal() {
        if (System.currentTimeMillis() - lastFetch > CACHE_TIMEOUT) {
            // Fetch Data From API
            val movieEntities = iTunesApi
                .search("star", "au", "movie", "") // Fetch from API
                .movies // Access MovieDto's
                .map { it.toMovie() } // Map MovieDto's to MovieEntities

            // Keep "viewed" value of the model
            val cachedMovies = movieDao.getAll()
            movieEntities.forEach { movieEntity ->
                val cachedMovie = cachedMovies.firstOrNull { it.id == movieEntity.id }
                movieEntity.viewed = cachedMovie?.viewed ?: false
            }

            movieDao.clear() // Clear Local Table of Movies
            movieDao.insertAll(movieEntities) // Insert new data of Movies

            lastFetch = System.currentTimeMillis()
        }
    }

}