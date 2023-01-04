package com.kmm.foodrecipeapp.android.navigation.destinations

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.kmm.foodrecipeapp.android.navigation.base.FRRoutes
import com.kmm.foodrecipeapp.android.utils.FoodAppPreference
import com.kmm.foodrecipeapp.android.utils.onStateConsumed
import com.kmm.foodrecipeapp.presentation.recipe.RecipeEffect
import com.kmm.foodrecipeapp.presentation.recipe.RecipeViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@Composable
fun RecipeDestinations(viewModel: RecipeViewModel, navControler: DestinationsNavigator) {
    val context = (LocalContext.current as Activity)
    val scope = rememberCoroutineScope()
    var prefManager = FoodAppPreference(context)
    onStateConsumed(viewModel::getStateProcessor, onEffect = { effect ->
        when (effect) {
            is RecipeEffect.NavigateToReicipeDetails -> {
                scope.launch {
                    prefManager.saveSelectedRecipe(effect.recipeModel)
                    navControler.navigate(FRRoutes.FR_DETAIL_SCREEN)
                }
            }
            is RecipeEffect.NavigateBack -> navControler.popBackStack()
        }
    })
}