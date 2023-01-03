package com.kmm.foodrecipeapp.presentation.welcome

import com.kmm.foodrecipeapp.base.interfaces.IBaseEffects
import com.kmm.foodrecipeapp.base.interfaces.IBaseEvents
import com.kmm.foodrecipeapp.base.interfaces.IBaseStateModel

sealed class WelcomeEffect : IBaseEffects {
    object NavigateToReicipeList : WelcomeEffect()
}


sealed class WelcomeEvent : IBaseEvents {

    object NavigateToReicipeList : WelcomeEvent()
}

data class WelcomeStateModel(
    val idel: String = ""
) : IBaseStateModel
