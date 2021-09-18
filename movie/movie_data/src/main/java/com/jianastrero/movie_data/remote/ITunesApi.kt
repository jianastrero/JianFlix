package com.jianastrero.movie_data.remote

import android.app.appsearch.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * API Interface for iTunes
 *
 * @author Jian James P. Astrero
 */
interface ITunesApi {

    /**
     * Search using the iTunes API
     */
    @GET("search")
    suspend fun search(
        @Query("term") term: String,
        @Query("country") country: String,
        @Query("media") media: String,
        @Query("all") all: String
    ): SearchResult

}