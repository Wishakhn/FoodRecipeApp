package com.kmm.foodrecipeapp.domain.model


data class RecipeModel(
    val count: Int? = 0,
    val recipes: List<RecipeInfoModel>? = arrayListOf()
)

data class RecipeInfoModel(
    val brandId: Int? = null,
    val country: String? = null,
    val description: String? = null,
    val id: Int? = null,
    val isShoppable: Boolean? = null,
    val name: String? = null,
    val numServings: Int? = null,
    val nutritionVisibility: String? = null,
    val prepTimeMinutes: Int? = null,
    val showId: Int? = null,
    val thumbnailUrl: String? = null,
)
