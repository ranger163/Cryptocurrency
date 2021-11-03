package me.inassar.cryptocurrency.common

/**
 * @author Nassar
 * Resource
 * This class is used as a data wrapper to help
 * passing data between business layers and knowing it's state.
 * @param T
 * @constructor Create empty Resource
 */
sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val errorMessage: String) : Resource<T>()

    companion object {
        fun <T> success(data: T) = Success(data = data)
        fun <T> error(message: String) = Error<T>(errorMessage = message)
    }
}
