package com.kmm.foodrecipeapp.presentation.details

import com.kmm.foodrecipeapp.base.interfaces.IBaseEffects
import com.kmm.foodrecipeapp.base.interfaces.IBaseEvents
import com.kmm.foodrecipeapp.base.interfaces.IBaseStateModel
import com.kmm.foodrecipeapp.domain.model.RecipeInfoModel
import com.kmm.foodrecipeapp.domain.model.RecipeModel

sealed class DetailEffect : IBaseEffects {
    object NavigateBack : DetailEffect()
}


sealed class DetailEvent : IBaseEvents {
    object NavigateBack : DetailEvent()
    data class UpdateSelectedRecipeInfo(val recipeInfo: RecipeInfoModel) : DetailEvent()
    data class HandleLoading(val data: RecipeModel?, val error: String?) : DetailEvent()
    data class FetchRecipeDetails(val id: Int) : DetailEvent()
}

data class DetailStateModel(
    val idel: String = "",
    val loading: Boolean = false,
    val data: RecipeModel? = null,
    val error: String? = null,
    val recipeInfo: RecipeInfoModel? = null
) : IBaseStateModel
