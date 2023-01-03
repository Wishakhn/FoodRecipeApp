package com.kmm.foodrecipeapp.domain.usecases

import com.kmm.foodrecipeapp.base.network.ApiResponse
import com.kmm.foodrecipeapp.base.usecase.BaseUseCase
import com.kmm.foodrecipeapp.data.details.IRDDataSource
import com.kmm.foodrecipeapp.domain.mappers.toRecipeModel
import com.kmm.foodrecipeapp.domain.model.RecipeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DetailUseCase(private val repository: IRDDataSource) : BaseUseCase<RecipeModel, Int>() {
    override suspend fun buildRequest(params: Int?): Flow<ApiResponse<RecipeModel>> = flow {
        repository.fetchRecipeDetails(params ?: 0).collect {
            when (it) {
                is ApiResponse.Success -> emit(ApiResponse.success(it.data.toRecipeModel()))
                is ApiResponse.Error -> emit(ApiResponse.error(it.error))
            }
        }
    }
}