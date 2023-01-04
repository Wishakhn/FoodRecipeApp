package com.kmm.foodrecipeapp.android.navigation.destinations

import androidx.compose.runtime.Composable
import com.kmm.foodrecipeapp.android.utils.onStateConsumed
import com.kmm.foodrecipeapp.presentation.details.DetailEffect
import com.kmm.foodrecipeapp.presentation.details.DetailViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun DetailsDestinations(viewModel: DetailViewModel, navControler: DestinationsNavigator) {
    onStateConsumed(viewModel::getStateProcessor, onEffect = { effect ->
        when (effect) {
            is DetailEffect.NavigateBack -> navControler.popBackStack()
        }
    })
}