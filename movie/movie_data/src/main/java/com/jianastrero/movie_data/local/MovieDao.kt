package com.jianastrero.movie_data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jianastrero.movie_data.local.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    suspend fun getAll(): List<Movie>

    @Query("SELECT * FROM movies WHERE id = :id LIMIT 1")
    suspend fun getById(id: String): Movie

    @Insert
    suspend fun insertAll(movies: List<Movie>)

    @Query("DELETE FROM movies")
    suspend fun clear()

}