package com.jianastrero.jianflix

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jianastrero.movie_data.local.MovieDao
import com.jianastrero.movie_data.local.model.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class JianFlixDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}