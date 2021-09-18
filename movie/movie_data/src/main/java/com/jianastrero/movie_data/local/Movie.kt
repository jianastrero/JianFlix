package com.jianastrero.movie_data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
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
    val releaseDate: String,
    @ColumnInfo(name = "time_in_millis")
    val timeInMillis: Long
)