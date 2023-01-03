package com.kmm.foodrecipeapp.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun FoodRecipeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = frTypography,
        shapes = Shapes,
        content = content
    )
}


private val DarkColorPalette = darkColors(
    primary = DarkOrange,
    primaryVariant = Mustard,
    secondary = White,
)

private val LightColorPalette = lightColors(
    primary = Mustard,
    primaryVariant = coolGreen,
    secondary = White
)