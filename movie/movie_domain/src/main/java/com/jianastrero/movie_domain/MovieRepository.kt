package com.jianastrero.movie_domain

import com.jianastrero.movie_domain.model.Movie

/**
 * Movie Repository Contract
 *
 * @author Jian James P. Astrero
 */
interface MovieRepository {

    /**
     * Get All Movie Domains
     *
     * @author Jian James P. Astrero
     */
    suspend fun getAll(): List<Movie>

    /**
     * Get Movie Domain by ID
     *
     * @param id The id of the Movie to be fetched
     *
     * @author Jian James P. Astrero
     */
    suspend fun getById(id: Int): Movie

    /**
     * Update Movie Domain
     *
     * @param id The id of the Movie to be fetched
     *
     * @author Jian James P. Astrero
     */
    suspend fun update(movie: Movie): Movie

    /**
     * Get All Movie Domains for Genre
     *
     * @param genre The genre of the movies to be fetched
     *
     * @author Jian James P. Astrero
     */
    suspend fun getMoviesByGenre(genre: String): List<Movie>

}