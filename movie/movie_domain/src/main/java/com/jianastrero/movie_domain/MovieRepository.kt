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
     * Get Movie Domain by ID
     *
     * @param id The id of the Movie to be fetched
     *
     * @author Jian James P. Astrero
     */
    suspend fun update(movie: Movie): Movie

}