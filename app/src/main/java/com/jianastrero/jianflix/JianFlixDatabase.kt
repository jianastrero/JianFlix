package com.jianastrero.jianflix

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jianastrero.jianflix.converter.LocalDateTimeTypeConverter
import com.jianastrero.movie_data.local.MovieDao
import com.jianastrero.movie_data.local.model.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1
)
@TypeConverters(LocalDateTimeTypeConverter::class)
abstract class JianFlixDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}