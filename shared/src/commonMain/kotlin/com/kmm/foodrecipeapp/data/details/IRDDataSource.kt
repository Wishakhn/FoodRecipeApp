package com.kmm.foodrecipeapp.data.details

import com.kmm.foodrecipeapp.base.network.ApiResponse
import com.kmm.foodrecipeapp.data.dto.DetailResponse
import com.kmm.foodrecipeapp.data.dto.RecipeResponse
import kotlinx.coroutines.flow.Flow


interface IRDDataSource {
    suspend fun fetchRecipeDetails(recipeId: Int): Flow<ApiResponse<DetailResponse>>
}