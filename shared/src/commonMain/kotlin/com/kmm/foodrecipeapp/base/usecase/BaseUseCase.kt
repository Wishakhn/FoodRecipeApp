package com.kmm.foodrecipeapp.base.usecase

import com.kmm.foodrecipeapp.base.network.ApiError
import com.kmm.foodrecipeapp.base.network.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Base Use Case class
 */
abstract class BaseUseCase<Model,Params> {
    abstract suspend fun buildRequest( params: Params?): Flow<ApiResponse<Model>>
    suspend fun execute( params: Params?): Flow<ApiResponse<Model>> {
        return try {
            buildRequest(params)
        } catch (exception: Exception) {
            flow { emit(ApiResponse.Error(ApiError(4003, message = exception.message ?: ""))) }
        }
    }
}
