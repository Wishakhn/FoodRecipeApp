package com.kmm.foodrecipeapp.data.details

import com.kmm.foodrecipeapp.base.network.ApiResponse
import com.kmm.foodrecipeapp.data.dto.DetailResponse


interface IRecipeDetailApi {
    suspend fun fetchRecipeDetails(recipeId: Int): ApiResponse<DetailResponse>
}