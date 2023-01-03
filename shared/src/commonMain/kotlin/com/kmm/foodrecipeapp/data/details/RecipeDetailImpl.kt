package com.kmm.foodrecipeapp.data.details

import com.kmm.foodrecipeapp.base.network.ApiResponse
import com.kmm.foodrecipeapp.data.dto.DetailResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeDetailImpl(
    private val remote: IRecipeDetailApi
) : IRDDataSource {
    override suspend fun fetchRecipeDetails(recipeId: Int): Flow<ApiResponse<DetailResponse>> =
        flow {
            when (val response = remote.fetchRecipeDetails(recipeId)) {
                is ApiResponse.Error -> emit(ApiResponse.error(response.error))
                is ApiResponse.Success -> emit(ApiResponse.success(response.data))
            }
        }
}