package com.kmm.foodrecipeapp.presentation.welcome

import com.kmm.foodrecipeapp.base.BaseViewModel
import com.kmm.foodrecipeapp.base.extenssion.thenNoAction
import com.kmm.foodrecipeapp.base.interfaces.Effects
import com.kmm.foodrecipeapp.base.interfaces.Intent
import kotlinx.coroutines.flow.Flow

class WelcomeViewModel : BaseViewModel<WelcomeEvent, WelcomeStateModel, WelcomeEffect>() {

    override fun createInitialState(): WelcomeStateModel = WelcomeStateModel()

    override fun handleStateEvents(
        event: WelcomeEvent,
        effect: Effects<WelcomeEffect>
    ): Flow<Intent<WelcomeStateModel>> = when (event) {
        is WelcomeEvent.NavigateToReicipeList -> effect.send(
            WelcomeEffect.NavigateToReicipeList
        ).thenNoAction()
    }
}
