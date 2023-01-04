package com.kmm.foodrecipeapp.presentation.recipe

import com.kmm.foodrecipeapp.base.interfaces.IBaseEffects
import com.kmm.foodrecipeapp.base.interfaces.IBaseEvents
import com.kmm.foodrecipeapp.base.interfaces.IBaseStateModel
import com.kmm.foodrecipeapp.domain.model.RecipeInfoModel
import com.kmm.foodrecipeapp.domain.model.RecipeModel

sealed class RecipeEffect : IBaseEffects {
    data class NavigateToReicipeDetails(val recipeModel: RecipeInfoModel) : RecipeEffect()
    object NavigateBack : RecipeEffect()
}


sealed class RecipeEvent : IBaseEvents {
    object RequestRecipeList : RecipeEvent()
    data class HandleLoading(val data: RecipeModel?, val error: String?) : RecipeEvent()
    data class NavigateToReicipeDetails(val recipeModel: RecipeInfoModel) : RecipeEvent()
    object NavigateBack : RecipeEvent()
}

data class RecipeStateModel(
    val idel: String = "",
    val data: RecipeModel? = null,
    val error: String? = null) : IBaseStateModel
