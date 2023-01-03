package com.kmm.foodrecipeapp.presentation.recipe

import com.kmm.foodrecipeapp.base.interfaces.Intent
import com.kmm.foodrecipeapp.domain.model.RecipeModel

sealed class RecipeStateReducer : Intent<RecipeStateModel> {
    data class HandleLoading(val data: RecipeModel?, val error: String?) : RecipeStateReducer() {
        override fun reduce(oldState: RecipeStateModel): RecipeStateModel =
            data?.let {
                oldState.copy(data = it)
            } ?: oldState.copy(error = error)
    }
}