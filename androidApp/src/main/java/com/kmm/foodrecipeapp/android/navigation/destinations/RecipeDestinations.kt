package com.kmm.foodrecipeapp.android.navigation.destinations

import androidx.compose.runtime.Composable
import com.kmm.foodrecipeapp.android.navigation.base.FRRoutes
import com.kmm.foodrecipeapp.android.utils.onStateConsumed
import com.kmm.foodrecipeapp.presentation.recipe.RecipeEffect
import com.kmm.foodrecipeapp.presentation.recipe.RecipeViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun RecipeDestinations(viewModel: RecipeViewModel, navControler: DestinationsNavigator) {
    onStateConsumed(viewModel::getStateProcessor, onEffect = { effect ->
        when (effect) {
            is RecipeEffect.NavigateToReicipeDetails -> {
                navControler.navigate(FRRoutes.FR_DETAIL_SCREEN)
            }
            is RecipeEffect.NavigateBack -> navControler.popBackStack()
        }
    })
}