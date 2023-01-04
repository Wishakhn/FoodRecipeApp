package com.kmm.foodrecipeapp.android.ui.recipedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.kmm.foodrecipeapp.android.R
import com.kmm.foodrecipeapp.android.theme.DullMustard
import com.kmm.foodrecipeapp.android.theme.MoonSurface
import com.kmm.foodrecipeapp.android.theme.White
import com.kmm.foodrecipeapp.android.theme.coolYellow
import com.kmm.foodrecipeapp.android.theme.frTypography
import com.kmm.foodrecipeapp.domain.model.RecipeInfoModel
import com.kmm.foodrecipeapp.domain.model.RecipeModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun RecipeInfo(
    modifier: Modifier,
    selectedRecipe: RecipeInfoModel?,
    processor: State<RecipeModel?>
) = ConstraintLayout(
    modifier = Modifier
        .fillMaxWidth()
        .background(White, shape = RoundedCornerShape(20.sdp, 20.sdp, 0.sdp, 0.sdp))
        .then(modifier)
) {
    val (ratingLogo, recipeText, description, ingredients) = createRefs()

    Image(
        painter = painterResource(id = R.drawable.ic_rating),
        contentDescription = "jjjj",
        modifier = Modifier
            .padding(start = 50.sdp, top = 10.sdp, end = 10.sdp)
            .height(50.sdp)
            .wrapContentWidth()
            .constrainAs(ratingLogo) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            }
    )

    Text(
        text = "RECIPE:",
        style = frTypography.h2.copy(DullMustard),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.sdp, start = 15.sdp)
            .constrainAs(recipeText) {
                linkTo(parent.start, parent.end)
                top.linkTo(parent.top)
            },
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
    Text(
        text = selectedRecipe?.description ?: "",
        style = frTypography.body2.copy(
            MoonSurface, fontSize = 10.ssp
        ),
        maxLines = 5,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.sdp, top = 10.sdp, end = 10.sdp, bottom = 10.sdp)
            .constrainAs(description) {
                linkTo(parent.start, parent.end)
                top.linkTo(recipeText.bottom)
            },
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.sdp, 0.sdp, 10.sdp, 20.sdp)
            .background(coolYellow, shape = RoundedCornerShape(20.sdp))
            .padding(0.sdp, 10.sdp, 0.sdp, 10.sdp)
            .constrainAs(
                ingredients
            ) {
                linkTo(parent.start, parent.end)
                top.linkTo(description.bottom)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
            }
    ) {
        items(processor.value?.recipes ?: listOf()) { item ->
            ItemIngredient(item)
        }
    }
}