package com.jianastrero.movie_data.remote.model

import com.google.gson.annotations.SerializedName
import com.jianastrero.movie_data.local.model.Movie

/**
 * Data Transfer Object received from API call
 *
 * @author Jian James P. Astrero
 */
data class MovieDto(
    @SerializedName("artistId")
    val artistId: Int,
    @SerializedName("artistName")
    val artistName: String,
    @SerializedName("artistViewUrl")
    val artistViewUrl: String,
    @SerializedName("artworkUrl100")
    val artworkUrl100: String,
    @SerializedName("artworkUrl30")
    val artworkUrl30: String,
    @SerializedName("artworkUrl60")
    val artworkUrl60: String,
    @SerializedName("collectionArtistId")
    val collectionArtistId: Int,
    @SerializedName("collectionArtistName")
    val collectionArtistName: String,
    @SerializedName("collectionArtistViewUrl")
    val collectionArtistViewUrl: String,
    @SerializedName("collectionCensoredName")
    val collectionCensoredName: String,
    @SerializedName("collectionExplicitness")
    val collectionExplicitness: String,
    @SerializedName("collectionHdPrice")
    val collectionHdPrice: Float,
    @SerializedName("collectionId")
    val collectionId: Int,
    @SerializedName("collectionName")
    val collectionName: String,
    @SerializedName("collectionPrice")
    val collectionPrice: Float,
    @SerializedName("collectionViewUrl")
    val collectionViewUrl: String,
    @SerializedName("contentAdvisoryRating")
    val contentAdvisoryRating: String,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("discCount")
    val discCount: Int,
    @SerializedName("discNumber")
    val discNumber: Int,
    @SerializedName("hasITunesExtras")
    val hasITunesExtras: Boolean,
    @SerializedName("isStreamable")
    val isStreamable: Boolean,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("longDescription")
    val longDescription: String,
    @SerializedName("previewUrl")
    val previewUrl: String,
    @SerializedName("primaryGenreName")
    val primaryGenreName: String,
    @SerializedName("releaseDate")
    val releaseDate: String,
    @SerializedName("shortDescription")
    val shortDescription: String,
    @SerializedName("trackCensoredName")
    val trackCensoredName: String,
    @SerializedName("trackCount")
    val trackCount: Int,
    @SerializedName("trackExplicitness")
    val trackExplicitness: String,
    @SerializedName("trackHdPrice")
    val trackHdPrice: Float,
    @SerializedName("trackHdRentalPrice")
    val trackHdRentalPrice: Float,
    @SerializedName("trackId")
    val trackId: Int,
    @SerializedName("trackName")
    val trackName: String,
    @SerializedName("trackNumber")
    val trackNumber: Int,
    @SerializedName("trackPrice")
    val trackPrice: Float,
    @SerializedName("trackRentalPrice")
    val trackRentalPrice: Float,
    @SerializedName("trackTimeMillis")
    val trackTimeMillis: Int,
    @SerializedName("trackViewUrl")
    val trackViewUrl: String,
    @SerializedName("wrapperType")
    val wrapperType: String
)

fun MovieDto.toMovie() = Movie(
    artwork = artworkUrl100,
    currency = currency,
    description = longDescription,
    genre = primaryGenreName,
    id = trackId,
    name = trackName,
    price = trackPrice,
    preview = previewUrl,
    releaseDate = releaseDate,
    timeInMillis = trackTimeMillis.toLong()
)