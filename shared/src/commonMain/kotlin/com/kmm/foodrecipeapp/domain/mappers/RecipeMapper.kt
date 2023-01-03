package com.kmm.foodrecipeapp.domain.mappers

import com.kmm.foodrecipeapp.data.dto.DetailResponse
import com.kmm.foodrecipeapp.data.dto.RecipeResponse
import com.kmm.foodrecipeapp.domain.model.RecipeInfoModel
import com.kmm.foodrecipeapp.domain.model.RecipeModel

fun RecipeResponse.toRecipeModel() = RecipeModel(
    count = count,
    recipes = recipes?.map {
        RecipeInfoModel(
            brandId = it.brandId,
            id = it.id,
            country = it.country,
            description = it.description,
            isShoppable = it.isShoppable,
            name = it.name,
            numServings = it.numServings,
            nutritionVisibility = it.nutritionVisibility,
            prepTimeMinutes = it.prepTimeMinutes,
            showId = it.showId,
            thumbnailUrl = it.thumbnailUrl
        )
    }?.toList()
)

fun DetailResponse.toRecipeModel() = RecipeModel(
    count = count,
    recipes = results?.map {
        RecipeInfoModel(
            brandId = it.brandId,
            id = it.id,
            country = it.country,
            description = it.description,
            isShoppable = it.isShoppable,
            name = it.name,
            numServings = it.numServings,
            nutritionVisibility = it.nutritionVisibility,
            prepTimeMinutes = it.prepTimeMinutes,
            showId = it.showId,
            thumbnailUrl = it.thumbnailUrl
        )
    }?.toList()
)

