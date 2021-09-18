package com.jianastrero.movie_data.remote.model


import com.google.gson.annotations.SerializedName

data class SearchResultDto(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val movies: List<MovieDto>
)