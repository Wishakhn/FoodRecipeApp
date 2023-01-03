package com.kmm.foodrecipeapp.android.ui.recipedetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.kmm.foodrecipeapp.android.theme.DullMustard
import com.kmm.foodrecipeapp.android.theme.MoonSurface
import com.kmm.foodrecipeapp.android.theme.White
import com.kmm.foodrecipeapp.android.theme.coolYellow
import com.kmm.foodrecipeapp.android.theme.frTypography
import com.kmm.foodrecipeapp.android.ui.recipe.getTrackingList
import ir.kaaveh.sdpcompose.sdp

@Composable
fun RecipeInfo(modifier: Modifier) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .background(White, shape = RoundedCornerShape(20.sdp, 20.sdp, 0.sdp, 0.sdp))
        .then(modifier)
) {
    Text(
        text = "RECIPE:",
        style = frTypography.h2.copy(DullMustard),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.sdp),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
    Text(
        text = "These pies have been recruited to the culinary secret service. They're licensed for sweetness and are proving it with every slice. We have <a href=\"https://tasty.co/recipe/chocolate-cookie -crust-peanut-butter-pie\">Chocolate Cookie Crust Peanut Butter Pie</a> for the code blues, or <a hr...",
        style = frTypography.body2.copy(
            MoonSurface
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.sdp, top = 10.sdp, end = 10.sdp, bottom = 10.sdp),
        textAlign = TextAlign.Justify
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.sdp, 0.sdp, 10.sdp, 20.sdp)
            .background(coolYellow, shape = RoundedCornerShape(20.sdp))
            .padding(0.sdp, 10.sdp, 0.sdp, 10.sdp)
    ) {
        items(getTrackingList()) { item ->
            ItemIngredient(item)
        }
    }
}