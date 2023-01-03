package com.kmm.foodrecipeapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.kmm.foodrecipeapp.android.theme.FoodRecipeTheme
import com.kmm.foodrecipeapp.android.ui.NavGraphs
import com.kmm.foodrecipeapp.android.ui.welcome.WelcomeScreen
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodRecipeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FoodRecipeNavHost()
                }
            }
        }
    }


    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
    @Preview(showBackground = true)
    @Composable
    fun FoodRecipeNavHost(modifier: Modifier = Modifier) {
        val engine = rememberAnimatedNavHostEngine()
        val navController = engine.rememberNavController()

        DestinationsNavHost(
            navGraph = NavGraphs.food,
            engine = engine,
            navController = navController
        )
    }
}

