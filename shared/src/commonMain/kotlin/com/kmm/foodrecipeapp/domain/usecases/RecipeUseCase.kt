package com.kmm.foodrecipeapp.domain.usecases

import com.kmm.foodrecipeapp.base.network.ApiResponse
import com.kmm.foodrecipeapp.base.usecase.BaseUseCase
import com.kmm.foodrecipeapp.data.recipe.IFRDataSource
import com.kmm.foodrecipeapp.domain.mappers.toRecipeModel
import com.kmm.foodrecipeapp.domain.model.RecipeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeUseCase(private val repository: IFRDataSource) : BaseUseCase<RecipeModel, Nothing>() {
    override suspend fun buildRequest(params: Nothing?): Flow<ApiResponse<RecipeModel>> = flow {
        repository.fetchRecipeList(0, 50).collect {
            when (it) {
                is ApiResponse.Success -> emit(ApiResponse.success(it.data.toRecipeModel()))
                is ApiResponse.Error -> emit(ApiResponse.error(it.error))
            }
        }
    }
}