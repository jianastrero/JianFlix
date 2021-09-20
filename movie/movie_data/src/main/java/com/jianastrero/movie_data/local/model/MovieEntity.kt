package com.jianastrero.movie_data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jianastrero.movie_domain.model.Movie
import java.time.LocalDateTime

/**
 * Local Database Entity Class for Movies
 *
 * @author Jian James P. Astrero
 */
@Entity(tableName = "movies")
data class MovieEntity(
    val artwork: String,
    val currency: String,
    val description: String,
    val genre: String,
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: Float,
    val preview: String,
    @ColumnInfo(name = "release_date")
    val releaseDate: LocalDateTime,
    @ColumnInfo(name = "time_in_millis")
    val timeInMillis: Long,
    var viewed: Boolean = false
)

/**
 * Convert a MovieEntity into a Movie Instance
 *
 * @author Jian James P. Astrero
 */
fun MovieEntity.toMovie() = Movie(
    artwork = artwork,
    currency = currency,
    description = description,
    genre = genre,
    id = id,
    name = name,
    price = price,
    preview = preview,
    releaseDate = releaseDate,
    timeInMillis = timeInMillis,
    viewed = viewed
)

/**
 * Convert a Movie into a MovieEntity Instance
 *
 * @author Jian James P. Astrero
 */
fun Movie.toMovieEntity() = MovieEntity(
    artwork = artwork,
    currency = currency,
    description = description,
    genre = genre,
    id = id,
    name = name,
    price = price,
    preview = preview,
    releaseDate = releaseDate,
    timeInMillis = timeInMillis,
    viewed = viewed
)