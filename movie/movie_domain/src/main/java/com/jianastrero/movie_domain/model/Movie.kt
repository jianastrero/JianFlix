package com.jianastrero.movie_domain.model

/**
 * Movie domain entity
 *
 * @author Jian James P. Astrero
 */
data class Movie(
    val artwork: String,
    val currency: String,
    val description: String,
    val genre: String,
    val id: Int,
    val name: String,
    val price: Float,
    val preview: String,
    val releaseDate: String,
    val timeInMillis: Long,
    var viewed: Boolean
)
