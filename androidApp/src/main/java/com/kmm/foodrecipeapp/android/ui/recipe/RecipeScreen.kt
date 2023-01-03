package com.kmm.foodrecipeapp.android.ui.recipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.kmm.foodrecipeapp.android.navigation.FoodNavGraph
import com.kmm.foodrecipeapp.android.navigation.base.DefaultTransitions
import com.kmm.foodrecipeapp.android.navigation.destinations.RecipeDestinations
import com.kmm.foodrecipeapp.android.theme.DarkOrange
import com.kmm.foodrecipeapp.android.theme.White
import com.kmm.foodrecipeapp.android.theme.frTypography
import com.kmm.foodrecipeapp.android.utils.collectAsState
import com.kmm.foodrecipeapp.domain.model.RecipeInfoModel
import com.kmm.foodrecipeapp.presentation.recipe.RecipeEvent
import com.kmm.foodrecipeapp.presentation.recipe.RecipeViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ir.kaaveh.sdpcompose.sdp
import org.koin.androidx.compose.koinViewModel

@FoodNavGraph(start = false)
@Destination(style = DefaultTransitions::class)
@Composable
fun RecipeScreen(destinationsNavigator: DestinationsNavigator) = ConstraintLayout(
    modifier = Modifier
        .fillMaxSize()
        .background(White)
) {
    val viewModel: RecipeViewModel = koinViewModel()
    val processor = viewModel.getStateProcessor()
    processor.sendEvent(RecipeEvent.RequestRecipeList)
    val reponse = processor.collectAsState { it.data }
    val error = processor.collectAsState {
        it.error
    }
    val (title, foodList, progress) = createRefs()
    Text(text = "FOOD RECIPES", style = frTypography.h1.copy(DarkOrange), modifier = Modifier
        .padding(top = 10.sdp)
        .constrainAs(title) {
            linkTo(parent.start, parent.end)
            top.linkTo(parent.top)
        })

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.sdp, 10.sdp, 0.sdp, 0.sdp)
            .constrainAs(foodList) {
                linkTo(title.bottom, parent.bottom)
                height = Dimension.fillToConstraints
            }

    ) {
        items(reponse.value?.recipes?: listOf()) { item ->
            Column(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                RecipeItemScreen(item, processor)
            }
        }
    }

    if (reponse.value == null && error.value.isNullOrBlank())
        CircularProgressIndicator(modifier = Modifier.constrainAs(progress) {
            linkTo(parent.start, parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })
    RecipeDestinations(viewModel, destinationsNavigator)
}

fun getTrackingList(): List<RecipeInfoModel> = arrayListOf(
    RecipeInfoModel(
        id = 0,
        name = "Zinger Burger"
    )
)


