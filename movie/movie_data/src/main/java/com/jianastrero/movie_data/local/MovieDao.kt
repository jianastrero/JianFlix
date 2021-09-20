package com.jianastrero.movie_data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jianastrero.movie_data.local.model.MovieEntity

/**
 * Local Database Transactions for Movies
 *
 * @author Jian James P. Astrero
 */
@Dao
interface MovieDao {

    /**
     * Get All Movies
     *
     * @author Jian James P. Astrero
     */
    @Query("SELECT * FROM movies")
    suspend fun getAll(): List<MovieEntity>

    /**
     * Get a Movie using its id
     *
     * @param id The id of the movie
     *
     * @author Jian James P. Astrero
     */
    @Query("SELECT * FROM movies WHERE id = :id LIMIT 1")
    suspend fun getById(id: Int): MovieEntity

    /**
     * Insert List of Movies
     *
     * @param movieEntities List of Movies to insert to local database
     *
     * @author Jian James P. Astrero
     */
    @Insert
    suspend fun insertAll(movieEntities: List<MovieEntity>)

    /**
     * Update Movie
     *
     * @param movieEntity Movie to update
     *
     * @author Jian James P. Astrero
     */
    @Update
    suspend fun update(movieEntity: MovieEntity)

    /**
     * Delete all Movies
     *
     * @author Jian James P. Astrero
     */
    @Query("DELETE FROM movies")
    suspend fun clear()

}