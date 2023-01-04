package com.kmm.foodrecipeapp.presentation.details

import com.kmm.foodrecipeapp.base.interfaces.Intent
import com.kmm.foodrecipeapp.domain.model.RecipeInfoModel
import com.kmm.foodrecipeapp.domain.model.RecipeModel

sealed class DetailStateReducer : Intent<DetailStateModel> {
    data class HandleLoading(val data: RecipeModel?, val error: String?) : DetailStateReducer() {
        override fun reduce(oldState: DetailStateModel): DetailStateModel =
            data?.let {
                oldState.copy(data = it)
            } ?: oldState.copy(error = error)
    }

    data class UpdateSelectedRecipeInfo(val recipeInfo: RecipeInfoModel) : DetailStateReducer() {
        override fun reduce(oldState: DetailStateModel): DetailStateModel =
            oldState.copy(recipeInfo = recipeInfo)
    }
}