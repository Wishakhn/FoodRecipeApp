package com.kmm.foodrecipeapp.data.recipe

import com.kmm.foodrecipeapp.base.network.ApiResponse
import com.kmm.foodrecipeapp.base.network.BaseRepository
import com.kmm.foodrecipeapp.base.network.KEY_AUTHORIZATION
import com.kmm.foodrecipeapp.base.network.TOKEN
import com.kmm.foodrecipeapp.data.dto.RecipeResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter

class FoodRecipeService(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : IFoodRecipeApi, BaseRepository() {
    override suspend fun fetchRecipeList(from: Int, size: Int): ApiResponse<RecipeResponse> {
        val response: ApiResponse<RecipeResponse> = execute {
            httpClient.get("$baseUrl/${URL_GET_RECIPES}") {
                header(KEY_AUTHORIZATION, TOKEN)
                parameter("from", from)
                parameter("size", size)
            }
        }
        when (response) {
            is ApiResponse.Error -> ApiResponse.error(response.error)
            is ApiResponse.Success -> ApiResponse.success(response.data)
            else -> {}
        }
        return response
    }

    companion object {
        const val URL_GET_RECIPES = "recipes/list"
    }
}

