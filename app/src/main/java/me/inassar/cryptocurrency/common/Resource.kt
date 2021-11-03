package me.inassar.cryptocurrency.common

/**
 * @author Nassar
 * Resource
 * This class is used as a data wrapper to help
 * passing data between layers and knowing it's state.
 * @param T
 * @property data
 * @property message
 * @constructor Create empty Resource
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String) : Resource<T>(message = message)
    class Loading<T>(data: T? = null) : Resource<T>(data = data)
}
