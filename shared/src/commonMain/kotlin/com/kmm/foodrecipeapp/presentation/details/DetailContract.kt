package com.kmm.foodrecipeapp.presentation.details

import com.kmm.foodrecipeapp.base.interfaces.IBaseEffects
import com.kmm.foodrecipeapp.base.interfaces.IBaseEvents
import com.kmm.foodrecipeapp.base.interfaces.IBaseStateModel
import com.kmm.foodrecipeapp.presentation.recipe.RecipeEvent

sealed class DetailEffect : IBaseEffects {
    object NavigateBack : DetailEffect()
}


sealed class DetailEvent : IBaseEvents {
    object NavigateBack : DetailEvent()
    data class HandleLoading(val isLoading: Boolean) : DetailEvent()
}

data class DetailStateModel(
    val idel: String = "",
    val loading: Boolean = false
) : IBaseStateModel
