package com.kmm.foodrecipeapp.android.ui.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kmm.foodrecipeapp.android.R
import com.kmm.foodrecipeapp.android.theme.BlackWhole
import com.kmm.foodrecipeapp.android.theme.MoonSurface
import com.kmm.foodrecipeapp.android.theme.coolCherry
import com.kmm.foodrecipeapp.android.theme.coolGreen
import com.kmm.foodrecipeapp.android.theme.coolOrange
import com.kmm.foodrecipeapp.android.theme.coolYellow
import com.kmm.foodrecipeapp.android.theme.frTypography
import com.kmm.foodrecipeapp.base.interfaces.StateEffectProcessor
import com.kmm.foodrecipeapp.domain.model.RecipeInfoModel
import com.kmm.foodrecipeapp.presentation.recipe.RecipeEffect
import com.kmm.foodrecipeapp.presentation.recipe.RecipeEvent
import com.kmm.foodrecipeapp.presentation.recipe.RecipeStateModel
import ir.kaaveh.sdpcompose.sdp

@Composable
fun RecipeItemScreen(
    item: RecipeInfoModel,
    processor: StateEffectProcessor<RecipeEvent, RecipeStateModel, RecipeEffect>
) = ConstraintLayout(
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(20.sdp, 20.sdp, 20.sdp, 0.sdp)
        .background(
            color = getRandomBackgroundColor()
                .asSequence()
                .shuffled()
                .find { true }
                ?: coolCherry,
            shape = RoundedCornerShape(10.sdp)
        )
        .padding(vertical = 10.sdp)
        .clickable {
            processor.sendEvent(RecipeEvent.NavigateToReicipeDetails(item))
        }
) {
    val (icon, title, subTitle, arrow) = createRefs()

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(item.thumbnailUrl)
            .crossfade(true)
            .build(),
        contentDescription = "",
        placeholder = painterResource(id = R.drawable.ic_burger),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(60.sdp)
            .width(60.sdp)
            .padding(10.sdp)
            .constrainAs(icon) {
                linkTo(parent.top, parent.bottom)
                start.linkTo(parent.start)
            }
    )

    Text(text = item.name ?: "No Name",
        style = frTypography.h3.copy(BlackWhole),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .padding(0.sdp, 5.sdp, 5.sdp, 0.sdp)
            .constrainAs(title) {
                top.linkTo(icon.top)
                start.linkTo(icon.end)
                end.linkTo(arrow.start)
                width = Dimension.fillToConstraints
            })

    Text(text = "This dish belongs to ${item.country}.",
        style = frTypography.body2.copy(MoonSurface),
        modifier = Modifier
            .padding(0.sdp, 0.sdp, 0.sdp, 10.sdp)
            .constrainAs(subTitle) {
                bottom.linkTo(icon.bottom)
                start.linkTo(icon.end)
            })

    Image(
        painter = painterResource(id = R.drawable.ic_arrow),
        contentDescription = "",
        modifier = Modifier
            .padding(end = 10.sdp)
            .constrainAs(arrow) {
                end.linkTo(parent.end)
                linkTo(parent.top, parent.bottom)
            }
    )


}

fun getRandomBackgroundColor(): List<Color> = arrayListOf(
    coolCherry,
    coolGreen,
    coolOrange,
    coolYellow
)