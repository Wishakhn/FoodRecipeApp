package com.kmm.foodrecipeapp.presentation.recipe

import com.kmm.foodrecipeapp.base.BaseViewModel
import com.kmm.foodrecipeapp.base.extenssion.thenNoAction
import com.kmm.foodrecipeapp.base.interfaces.Effects
import com.kmm.foodrecipeapp.base.interfaces.Intent
import com.kmm.foodrecipeapp.base.network.ApiResponse
import com.kmm.foodrecipeapp.domain.usecases.RecipeUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val recipeUseCase: RecipeUseCase
) : BaseViewModel<RecipeEvent, RecipeStateModel, RecipeEffect>() {

    override fun createInitialState(): RecipeStateModel = RecipeStateModel()

    override fun handleStateEvents(
        event: RecipeEvent, effect: Effects<RecipeEffect>
    ): Flow<Intent<RecipeStateModel>> = when (event) {
        is RecipeEvent.NavigateToReicipeDetails -> effect.send(
            RecipeEffect.NavigateToReicipeDetails(event.recipeModel)
        ).thenNoAction()
        is RecipeEvent.NavigateBack -> effect.send(RecipeEffect.NavigateBack).thenNoAction()
        is RecipeEvent.HandleLoading -> flowOf(
            RecipeStateReducer.HandleLoading(
                event.data,
                event.error
            )
        )
        is RecipeEvent.RequestRecipeList -> fetchRecipeList().thenNoAction()
    }

    private fun fetchRecipeList() = viewModelScope.launch {
        recipeUseCase.execute(null).onStart { }.collect { response ->
            when (response) {
                is ApiResponse.Success -> {
                    setEvent(RecipeEvent.HandleLoading(response.data, null))
                }
                is ApiResponse.Error -> {
                    setEvent(RecipeEvent.HandleLoading(null, response.error.message))
                }
            }

        }
    }
}
