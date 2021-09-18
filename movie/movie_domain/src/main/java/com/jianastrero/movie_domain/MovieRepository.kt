package com.jianastrero.movie_domain

import com.jianastrero.movie_domain.model.Movie

interface MovieRepository {

    suspend fun getAll(): List<Movie>

    suspend fun getById(id: Int): Movie

}