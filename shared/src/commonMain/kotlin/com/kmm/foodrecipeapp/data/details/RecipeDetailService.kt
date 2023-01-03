package com.kmm.foodrecipeapp.data.details

import com.kmm.foodrecipeapp.base.network.ApiResponse
import com.kmm.foodrecipeapp.base.network.BaseRepository
import com.kmm.foodrecipeapp.base.network.KEY_AUTHORIZATION
import com.kmm.foodrecipeapp.base.network.TOKEN
import com.kmm.foodrecipeapp.data.dto.DetailResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter

class RecipeDetailService(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : IRecipeDetailApi, BaseRepository() {
    override suspend fun fetchRecipeDetails(recipeId: Int): ApiResponse<DetailResponse> {
        val response: ApiResponse<DetailResponse> = execute {
            httpClient.get("$baseUrl/${URL_GET_RECIPE_DETAILS}") {
                header(KEY_AUTHORIZATION, TOKEN)
                parameter("recipe_id", recipeId)
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
        const val URL_GET_RECIPE_DETAILS = "recipes/list-similarities"
    }
}