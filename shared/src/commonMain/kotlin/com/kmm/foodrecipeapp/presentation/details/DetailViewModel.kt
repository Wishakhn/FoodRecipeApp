package com.kmm.foodrecipeapp.presentation.details

import com.kmm.foodrecipeapp.base.BaseViewModel
import com.kmm.foodrecipeapp.base.extenssion.thenNoAction
import com.kmm.foodrecipeapp.base.interfaces.Effects
import com.kmm.foodrecipeapp.base.interfaces.Intent
import com.kmm.foodrecipeapp.base.network.ApiResponse
import com.kmm.foodrecipeapp.domain.usecases.DetailUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DetailViewModel(
    private val detailUseCase: DetailUseCase

) : BaseViewModel<DetailEvent, DetailStateModel, DetailEffect>() {

    override fun createInitialState(): DetailStateModel = DetailStateModel()

    override fun handleStateEvents(
        event: DetailEvent, effect: Effects<DetailEffect>
    ): Flow<Intent<DetailStateModel>> = when (event) {
        is DetailEvent.NavigateBack -> effect.send(
            DetailEffect.NavigateBack
        ).thenNoAction()
        is DetailEvent.HandleLoading -> flowOf(DetailStateReducer.HandleLoading(event.data, event.error))
        is DetailEvent.FetchRecipeDetails -> fetchRecipeDetails(event.id).thenNoAction()
        is DetailEvent.UpdateSelectedRecipeInfo -> flowOf(DetailStateReducer.UpdateSelectedRecipeInfo(event.recipeInfo))

    }

    private fun fetchRecipeDetails(id: Int) = viewModelScope.launch {
        detailUseCase.execute(null).onStart { }.collect { response ->
            when (response) {
                is ApiResponse.Success -> {
                    setEvent(DetailEvent.HandleLoading(response.data,null))
                }
                is ApiResponse.Error -> {
                    setEvent(DetailEvent.HandleLoading(null,response.error.message?:"Something Went Wrong"))
                }
            }

        }
    }
}
