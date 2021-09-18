package com.jianastrero.core.domain

/**
 * Resource class for retrieving data with use-cases
 *
 * @author Jian James P. Astrero
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {

    /**
     * Resource for Loading Data
     *
     * @author Jian James P. Astrero
     */
    class Loading<T> : Resource<T>()

    /**
     * Resource for Successful Retrieval of Data
     *
     * @author Jian James P. Astrero
     */
    class Success<T>(data: T) : Resource<T>(data)

    /**
     * Resource for Error in Loading Data
     *
     * @author Jian James P. Astrero
     */
    open class Error<T>(message: String) : Resource<T>(message = message) {

        /**
         * Resource for No Internet Connection
         *
         * @author Jian James P. Astrero
         */
        class NoInternetConnectionError<T> : Error<T>("Cannot connect to server's. Please check your internet connection.")

        /**
         * Resource for Unexpected Error
         *
         * @author Jian James P. Astrero
         */
        class UnexpectedError<T> : Error<T>("An Unexpected error occurred, please try again later.")

    }

}