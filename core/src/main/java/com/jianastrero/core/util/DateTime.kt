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