package com.kmm.foodrecipeapp.data.dto

import com.kmm.foodrecipeapp.base.network.BaseApiResponse
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class RecipeResponse(
    @SerialName("count")
    val count: Int? = 0,
    @SerialName("results")
    val recipes: List<Recipe>? = arrayListOf()
): BaseApiResponse()
