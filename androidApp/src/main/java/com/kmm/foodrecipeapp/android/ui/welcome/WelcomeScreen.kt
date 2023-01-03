package com.kmm.foodrecipeapp.android.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.kmm.foodrecipeapp.android.R
import com.kmm.foodrecipeapp.android.navigation.FoodNavGraph
import com.kmm.foodrecipeapp.android.navigation.base.DefaultTransitions
import com.kmm.foodrecipeapp.android.navigation.destinations.WelcomeScreenDestination
import com.kmm.foodrecipeapp.android.theme.BrightYellow
import com.kmm.foodrecipeapp.android.theme.DarkMustard
import com.kmm.foodrecipeapp.android.theme.DrawableWrapper
import com.kmm.foodrecipeapp.android.theme.DullMustard
import com.kmm.foodrecipeapp.android.theme.DullOrange
import com.kmm.foodrecipeapp.android.theme.MediumMustard
import com.kmm.foodrecipeapp.android.theme.Shapes
import com.kmm.foodrecipeapp.android.theme.SharpOrange
import com.kmm.foodrecipeapp.android.theme.White
import com.kmm.foodrecipeapp.android.theme.frTypography
import com.kmm.foodrecipeapp.presentation.welcome.WelcomeEvent
import com.kmm.foodrecipeapp.presentation.welcome.WelcomeViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ir.kaaveh.sdpcompose.sdp
import org.koin.androidx.compose.koinViewModel

@FoodNavGraph(start = true)
@Destination(style = DefaultTransitions::class)
@Composable
fun WelcomeScreen(destinationsNavigator: DestinationsNavigator) = ConstraintLayout(
    modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    DullOrange,
                    DullOrange,
                    DullOrange,
                    SharpOrange
                )
            )
        )
) {
    val viewModel : WelcomeViewModel = koinViewModel()
    val processor = viewModel.getStateProcessor()
    val (topLayer, Title, subTitle, button) = createRefs()
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 150.sdp)
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    BrightYellow,
                    MediumMustard,
                    MediumMustard,
                    DullMustard,
                    DarkMustard
                )
            ), shape = RoundedCornerShape(0.sdp, 0.sdp, 25.sdp, 25.sdp)
        )
        .constrainAs(topLayer) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            height = Dimension.fillToConstraints
        }) {
        Image(
            painter = painterResource(id = R.drawable.ic_think_food),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.sdp)
                .align(
                    Alignment.BottomCenter
                )
        )

    }

    Text(text = "Welcome To The", style = frTypography.h3.copy(White), modifier = Modifier
        .padding(top = 30.sdp)
        .constrainAs(subTitle) {
            linkTo(parent.start, parent.end)
            top.linkTo(parent.top)
        })
    Text(text = "FOOD RECIPES", style = frTypography.h1.copy(White), modifier = Modifier
        .padding(top = 10.sdp)
        .constrainAs(Title) {
            linkTo(parent.start, parent.end)
            top.linkTo(subTitle.bottom)
        })

    Button(
        onClick = {
            processor.sendEvent(WelcomeEvent.NavigateToReicipeList)
        },
        enabled = true,
        colors = ButtonDefaults.buttonColors(backgroundColor = White),
        shape = Shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.sdp, 20.sdp, 16.sdp, 40.sdp)
            .height(45.sdp)
            .constrainAs(button) {
                linkTo(parent.start, parent.end)
                bottom.linkTo(parent.bottom)
            }
    ) {
        DrawableWrapper(drawableEnd = R.drawable.ic_arrow) {
            Text(text = "Welcome", style = frTypography.button.copy(DullOrange))
        }
    }

    WelcomeScreenDestination(viewModel,destinationsNavigator)
}