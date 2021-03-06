package com.jianastrero.core.util

import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * Convert String to LocalDateTime
 *
 *
 * @author Jian James P. Astrero
 */
fun String.toLocalDateTime(): LocalDateTime =
    ZonedDateTime.parse(replace("Z$".toRegex(), "+00:00"))
        .toLocalDateTime()

/**
 * Convert milliseconds to Readable Hours, Minutes and Seconds
 *
 * @author Jian James P. Astrero
 */
fun Long.toReadableHoursMinutesAndSeconds(): String {
    val seconds = this / 1000
    val s = seconds % 60
    val m = seconds / 60 % 60
    val h = seconds / (60 * 60) % 24
    return String.format("%d hours, %02d minutes %02d seconds", h, m, s)
}

private val readableMonthDayYearFormatter: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern("MMMM d, yyyy")
}
/**
 * Convert LocalDateTime to Readable Month Day, Year
 *
 * @author Jian James P. Astrero
 */
fun LocalDateTime.toReadableMonthDayYear(): String = readableMonthDayYearFormatter.format(this)