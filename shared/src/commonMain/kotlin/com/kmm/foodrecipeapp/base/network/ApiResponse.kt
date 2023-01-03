package com.kmm.foodrecipeapp.base.network


sealed class ApiResponse<out T> {
    data class Success<out T : Any>(val code: Int, val data: T) : ApiResponse<T>()
    data class Error(val error: ApiError) : ApiResponse<Nothing>()

    companion object {
        fun <T : Any> success(data: T) = Success(200, data)
        fun <T : ApiError> error(errorMessage: T) = Error(errorMessage)
    }
}

