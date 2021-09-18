package com.jianastrero.core.util

class Logger(
    private val isDebug: Boolean,
    private val defaultTag: String
) {

    fun init() {
        INSTANCE = this
    }

    fun log(tag: String = defaultTag, message: String) {
        if (isDebug) {
            println("$tag: $message")
        } else {
            // TODO: If not in debug mode, log on crashlytics or other similar services
        }
    }

    companion object {
        internal lateinit var INSTANCE: Logger
    }
}

fun String.log() = Logger.INSTANCE.log(message = this)

fun String.log(tag: String) = Logger.INSTANCE.log(tag, this)