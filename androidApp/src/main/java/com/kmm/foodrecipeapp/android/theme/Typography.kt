package com.kmm.foodrecipeapp.android.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.kmm.foodrecipeapp.android.R
import ir.kaaveh.sdpcompose.ssp
import java.util.TreeMap


val UrbanistBold = Font(R.font.urbanist_bold)
val UrbanistRegular = Font(R.font.urbanist_regular)
val UrbanistMedium = Font(R.font.urbanist_medium)
val UrbanistItalic = Font(R.font.urbanist_italic)

val FRFonts: FontFamily
    @Composable
    get() = FontFamily(
        listOf(
            UrbanistBold,
            UrbanistRegular,
            UrbanistMedium,
            UrbanistItalic
        )
    )

val frTypography: Typography
    @Composable
    get() = Typography(
        defaultFontFamily = FRFonts,
        h1 = TextStyle(
            color = DarkOrange,
            lineHeight = 36.ssp,
            fontWeight = FontWeight.Black,
            fontSize = 26.ssp,
            fontFamily = FontFamily(UrbanistBold)
        ),
        h2 = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.ssp,
            lineHeight = 26.ssp,
            color = BlackWhole,
            fontFamily = FontFamily(UrbanistBold)
        ),
        h3 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.ssp,
            lineHeight = 20.ssp,
            color = MoonSurface,
            fontFamily = FontFamily(UrbanistRegular)
        ),
        body1 = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 14.ssp,
            lineHeight = 20.ssp,
            color = BlackWhole,
            fontFamily = FontFamily(UrbanistRegular),
        ),
        body2 = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 12.ssp,
            lineHeight = 20.ssp,
            color = MoonSurface,
            fontFamily = FontFamily(UrbanistRegular),
        ),
        button = TextStyle(
            fontWeight = FontWeight.Medium,
            color = White,
            fontSize = 12.ssp,
            lineHeight = 22.ssp,
            fontFamily = FontFamily(UrbanistRegular)
        )
    )

fun spannableTextBuilder(textChunks: TreeMap<String, Color>): AnnotatedString =
    buildAnnotatedString {
        textChunks.forEach { map ->
            withStyle(style = SpanStyle(color = map.value)) {
                append(map.key)
            }
        }
    }
