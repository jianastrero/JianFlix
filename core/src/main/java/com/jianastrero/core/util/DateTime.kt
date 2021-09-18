package com.jianastrero.core.util

import java.time.LocalDateTime
import java.time.ZonedDateTime

fun String.toLocalDateTime(): LocalDateTime =
    ZonedDateTime.parse(replace("Z$".toRegex(), "+00:00"))
        .toLocalDateTime()