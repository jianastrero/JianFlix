package com.jianastrero.core.domain

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {

    object Loading : Resource<Nothing>()
    class Success<T>(data: T) : Resource<T>(data)

    sealed class Error(message: String) : Resource<Nothing>(message = message) {
        object NoInternetConnectionError : Error("Cannot connect to server's. Please check your internet connection.")
        object UnexpectedError : Error("An Unexpected error occurred, please try again later.")
    }

}