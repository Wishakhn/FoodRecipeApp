package com.kmm.foodrecipeapp.data.recipe

import com.kmm.foodrecipeapp.base.network.ApiResponse
import com.kmm.foodrecipeapp.data.dto.RecipeResponse
import kotlinx.coroutines.flow.Flow


interface IFRDataSource {
    suspend fun fetchRecipeList(from: Int = 0, size: Int = 0): Flow<ApiResponse<RecipeResponse>>
}