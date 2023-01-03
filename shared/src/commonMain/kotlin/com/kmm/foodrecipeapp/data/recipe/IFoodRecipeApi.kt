package com.kmm.foodrecipeapp.data.recipe

import com.kmm.foodrecipeapp.base.network.ApiResponse
import com.kmm.foodrecipeapp.data.dto.RecipeResponse


interface IFoodRecipeApi {
    suspend fun fetchRecipeList(from: Int = 0, size: Int = 0): ApiResponse<RecipeResponse>
}