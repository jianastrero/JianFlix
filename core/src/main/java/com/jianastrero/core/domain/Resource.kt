package com.jianastrero.core.domain

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Loading<T> : Resource<T>()
    class Success<T>(data: T) : Resource<T>(data)

    open class Error<T>(message: String) : Resource<T>(message = message) {

        class NoInternetConnectionError<T> : Error<T>("Cannot connect to server's. Please check your internet connection.")
        class UnexpectedError<T> : Error<T>("An Unexpected error occurred, please try again later.")

    }

}