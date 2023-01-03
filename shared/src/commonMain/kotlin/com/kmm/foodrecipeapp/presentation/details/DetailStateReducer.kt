package com.kmm.foodrecipeapp.presentation.details

import com.kmm.foodrecipeapp.base.interfaces.Intent

sealed class DetailStateReducer : Intent<DetailStateModel> {
    data class HandleLoading(val isLoading: Boolean) : DetailStateReducer() {
        override fun reduce(oldState: DetailStateModel): DetailStateModel =
            oldState.copy(loading = isLoading)
    }
}