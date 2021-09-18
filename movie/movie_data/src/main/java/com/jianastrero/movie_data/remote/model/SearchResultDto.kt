package com.jianastrero.movie_data.remote.model

import com.google.gson.annotations.SerializedName

/***
 * Data Transfer Object received from the API call
 *
 * @author Jian James P. Astrero
 */
data class SearchResultDto(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val movies: List<MovieDto>
)