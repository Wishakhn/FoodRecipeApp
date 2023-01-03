package com.kmm.foodrecipeapp.base.network


import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
const val KEY_AUTHORIZATION = "X-RapidAPI-Key"
const val TOKEN = "ec4eb43342msha35991c62fe53d5p1b64bdjsne94be746f828"

abstract class BaseRepository {
    private val defaultErrorMessage =
        "Sorry, that doesn't look right. We’re working on fixing it now. Please try again in sometime."
    private val defaultConnectionErrorMessage =
        "Looks like you're offline. Please reconnect and refresh to continue."
    private val defaultSessionMessage =
        "Your session has been expired"

    suspend inline fun <reified T : Any> execute(call: () -> HttpResponse): ApiResponse<T> {
        val response = call.invoke()
        return try {
            when (response.status) {
                HttpStatusCode.OK -> ApiResponse.success(response.body())
                else -> ApiResponse.error(detectError(response.body()))
            }
        } catch (e: Exception) {
            val error = ApiError(400, e.message ?: "Something went wrong")
            ApiResponse.Error(error)
        }
    }

    suspend fun detectError(response: HttpResponse): ApiError {
        return when (val statusCode = response.status.value) {
            401 -> getApiError(mapError(NetworkErrors.SessionExpire, statusCode))
            403 -> getApiError(mapError(NetworkErrors.Forbidden, statusCode))
            404 -> getApiError(mapError(NetworkErrors.NotFound, statusCode))
            502 -> getApiError(mapError(NetworkErrors.BadGateway, statusCode))
            504 -> getApiError(mapError(NetworkErrors.NoInternet, statusCode))
            in 400..500 -> response.body<ApiError>().copy(statusCode = statusCode)
            -1009 -> getApiError(mapError(NetworkErrors.NoInternet, statusCode))
            -1001 -> getApiError(mapError(NetworkErrors.RequestTimedOut, statusCode))
            else -> {
                getApiError(mapError(NetworkErrors.UnknownError(), statusCode))
            }
        }
    }

    private fun getError(): ServerError = ServerError(getDefaultCode(), defaultErrorMessage)


    private fun getApiError(error: ServerError): ApiError {
        return ApiError(
            error.code ?: getDefaultCode(),
            error.message ?: defaultErrorMessage,
            error.actualCode
        )
    }

    private fun mapError(error: NetworkErrors, code: Int = 0): ServerError {
        return when (error) {

            is NetworkErrors.NoInternet, NetworkErrors.RequestTimedOut -> ServerError(
                code,
                defaultConnectionErrorMessage
            )

            is NetworkErrors.BadGateway -> ServerError(code, defaultErrorMessage)
            is NetworkErrors.NotFound -> ServerError(code, defaultErrorMessage)
            is NetworkErrors.Forbidden -> ServerError(
                code,
                "You don't have access to this information"
            )
            is NetworkErrors.InternalServerError -> getError()
            is NetworkErrors.SessionExpire -> ServerError(code, defaultSessionMessage)
            is NetworkErrors.UnknownError -> ServerError(code, defaultErrorMessage)
        }
    }


    private fun getDefaultCode(): Int {
        return 0
    }

    data class ServerError(val code: Int?, val message: String?, val actualCode: String = "-1")

    sealed class NetworkErrors {
        object NoInternet : NetworkErrors()
        object RequestTimedOut : NetworkErrors()
        object BadGateway : NetworkErrors()
        object NotFound : NetworkErrors()
        object Forbidden : NetworkErrors()
        object SessionExpire : NetworkErrors()
        class InternalServerError(val response: String?) : NetworkErrors()
        open class UnknownError : NetworkErrors()
    }

}

