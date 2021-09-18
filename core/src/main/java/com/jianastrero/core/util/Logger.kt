package com.jianastrero.core.util

/**
 * Logger class to use for loggin to logcat or somewhere else like crashlytics
 *
 * @param isDebug If true, log through the logcat. else, log somewhere else
 * @param defaultTag The default tag for logs
 * @constructor Creates an Instance of Logger
 */
class Logger(
    private val isDebug: Boolean,
    private val defaultTag: String
) {

    /**
     * Initialize Logger
     */
    fun init() {
        INSTANCE = this
    }

    /**
     * Log a message with a tag to the Logger
     *
     * @param tag The tag to use for this log message. Default: defaultTag provided on initialization
     * @param message The message for this log.
     */
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