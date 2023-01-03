package com.kmm.foodrecipeapp.data.recipe

import com.kmm.foodrecipeapp.base.network.ApiResponse
import com.kmm.foodrecipeapp.data.dto.RecipeResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FoodRecipeImpl(
    private val remote: IFoodRecipeApi
) : IFRDataSource {
    override suspend fun fetchRecipeList(from: Int, size: Int): Flow<ApiResponse<RecipeResponse>> =
        flow {
            when (val response = remote.fetchRecipeList(from, size)) {
                is ApiResponse.Error -> emit(ApiResponse.error(response.error))
                is ApiResponse.Success -> emit(ApiResponse.success(response.data))
            }
        }
}