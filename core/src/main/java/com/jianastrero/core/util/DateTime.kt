package com.jianastrero.core.util

import java.time.LocalDateTime
import java.time.ZonedDateTime

/**
 * Convert String to LocalDateTime
 *
 *
 * @author Jian James P. Astrero
 */
fun String.toLocalDateTime(): LocalDateTime =
    ZonedDateTime.parse(replace("Z$".toRegex(), "+00:00"))
        .toLocalDateTime()

fun Long.toReadableHoursMinutesAndSeconds(): String {
    val seconds = this / 1000
    val s = seconds % 60
    val m = seconds / 60 % 60
    val h = seconds / (60 * 60) % 24
    return String.format("%d hours, %02d minutes %02d seconds", h, m, s)
}