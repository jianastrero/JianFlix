package com.jianastrero.jianflix.converter

import androidx.room.TypeConverter
import java.time.LocalDateTime

/**
 * Type converters for saving LocalDateTime to Room Persistence Library
 *
 * @author Jian James P. Astrero
 */
class LocalDateTimeTypeConverter {

    @TypeConverter
    fun toDate(dateString: String): LocalDateTime =
        LocalDateTime.parse(dateString)

    @TypeConverter
    fun toDateString(date: LocalDateTime): String =
        date.toString()

}