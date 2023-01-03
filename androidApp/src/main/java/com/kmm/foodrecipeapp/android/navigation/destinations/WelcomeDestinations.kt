package com.kmm.foodrecipeapp.android.navigation.destinations

import androidx.compose.runtime.Composable
import com.kmm.foodrecipeapp.android.navigation.base.FRRoutes
import com.kmm.foodrecipeapp.presentation.welcome.WelcomeEffect
import com.kmm.foodrecipeapp.presentation.welcome.WelcomeViewModel
import com.kmm.foodrecipeapp.android.utils.onStateConsumed
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun WelcomeScreenDestination(viewModel: WelcomeViewModel, navControler: DestinationsNavigator) {
    onStateConsumed(viewModel::getStateProcessor, onEffect = { effect ->
        when (effect) {
            is WelcomeEffect.NavigateToReicipeList -> {
                navControler.navigate(FRRoutes.FR_HOME_SCREEN)
            }
        }
    })
}
