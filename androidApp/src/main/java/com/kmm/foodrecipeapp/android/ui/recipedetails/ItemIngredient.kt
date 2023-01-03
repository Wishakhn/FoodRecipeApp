package com.kmm.foodrecipeapp.android.ui.recipedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.kmm.foodrecipeapp.android.R
import com.kmm.foodrecipeapp.android.theme.DarkMustard
import com.kmm.foodrecipeapp.android.theme.frTypography
import com.kmm.foodrecipeapp.domain.model.RecipeInfoModel
import ir.kaaveh.sdpcompose.sdp

@Composable
fun ItemIngredient(item: RecipeInfoModel) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(5.sdp, 0.sdp, 10.sdp, 0.sdp)
) {
    Image(
        painter = painterResource(id = R.drawable.ic_burger),
        contentDescription = "",
        modifier = Modifier
            .height(50.sdp)
            .padding(10.sdp)
    )
    Text(
        text = "sjdjd",
        style = frTypography.body2.copy(DarkMustard),
        modifier = Modifier
            .padding(0.sdp, 0.sdp, 0.sdp, 0.sdp)
            .align(Alignment.CenterVertically)
    )

}