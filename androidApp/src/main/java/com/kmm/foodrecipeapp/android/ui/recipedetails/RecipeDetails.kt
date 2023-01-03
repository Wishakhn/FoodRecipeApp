package com.kmm.foodrecipeapp.android.ui.recipedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.kmm.foodrecipeapp.android.R
import com.kmm.foodrecipeapp.android.navigation.FoodNavGraph
import com.kmm.foodrecipeapp.android.navigation.base.DefaultTransitions
import com.kmm.foodrecipeapp.android.navigation.destinations.RecipeDestinations
import com.kmm.foodrecipeapp.android.theme.DarkOrange
import com.kmm.foodrecipeapp.android.theme.DullOrange
import com.kmm.foodrecipeapp.android.theme.SharpOrange
import com.kmm.foodrecipeapp.android.theme.coolGreen
import com.kmm.foodrecipeapp.android.theme.coolOrange
import com.kmm.foodrecipeapp.android.theme.frTypography
import com.kmm.foodrecipeapp.presentation.details.DetailEvent
import com.kmm.foodrecipeapp.presentation.details.DetailViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ir.kaaveh.sdpcompose.sdp
import org.koin.androidx.compose.koinViewModel

@FoodNavGraph(start = false)
@Destination(style = DefaultTransitions::class)
@Composable
fun RecipeDetails(destinationsNavigator: DestinationsNavigator) = ConstraintLayout(
    modifier = Modifier
        .fillMaxSize()
        .background(DarkOrange)
) {
    val viewModel: DetailViewModel = koinViewModel()
    val processor = viewModel.getStateProcessor()
    val (back, header, recipeImage, infoContainer) = createRefs()

    Text(
        text = "Zinger Burger", style = frTypography.h1.copy(DullOrange), modifier = Modifier
            .fillMaxWidth()
            .background(color = coolOrange)
            .padding(top = 10.sdp)
            .constrainAs(header) {
                linkTo(parent.start, parent.end)
                top.linkTo(parent.top)
            }, textAlign = TextAlign.Center
    )
    Image(
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = "",
        modifier = Modifier
            .padding(start = 20.sdp, top = 10.sdp)
            .constrainAs(back) {
                top.linkTo(parent.top)
                bottom.linkTo(header.bottom)
                start.linkTo(parent.start)
            }
            .clickable {
                processor.sendEvent(DetailEvent.NavigateBack)
            })
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.sdp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        coolOrange,
                        SharpOrange,
                        SharpOrange,
                        DarkOrange,
                    )
                )
            )
            .constrainAs(recipeImage) {
                linkTo(parent.start, parent.end)
                top.linkTo(header.bottom)
            }, horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_burger),
            contentDescription = "",
            modifier = Modifier
                .align(CenterVertically)
                .height(140.sdp)
                .width(140.sdp)
                .background(shape = RoundedCornerShape(80.sdp), color = coolGreen)
                .padding(20.sdp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_announcement),
            contentDescription = "",
            modifier = Modifier
                .align(CenterVertically)
                .padding(top = 30.sdp)
                .height(120.sdp)
                .wrapContentWidth()
        )
    }
    RecipeInfo(modifier = Modifier.constrainAs(infoContainer) {
        linkTo(parent.start, parent.end)
        top.linkTo(recipeImage.bottom)
        bottom.linkTo(parent.bottom)
        height = Dimension.fillToConstraints
    })
    RecipeDestinations(viewModel, destinationsNavigator)
}


