package com.kmm.foodrecipeapp.android.navigation.base

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry
import com.ramcosta.composedestinations.spec.DestinationStyle

@OptIn(ExperimentalAnimationApi::class)
object DefaultTransitions : DestinationStyle.Animated {

    private const val animationDuration: Int = 200
    override fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition? {
        return slideInHorizontally(
            initialOffsetX = { 1000 },
            animationSpec = tween(animationDuration)
        )
    }

    override fun AnimatedContentScope<NavBackStackEntry>.exitTransition(): ExitTransition? {
        return slideOutHorizontally(
            targetOffsetX = { -1000 },
            animationSpec = tween(animationDuration)
        )
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popEnterTransition(): EnterTransition? {
        return slideInHorizontally(
            initialOffsetX = { -1000 },
            animationSpec = tween(animationDuration)
        )
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popExitTransition(): ExitTransition? {
        return slideOutHorizontally(
            targetOffsetX = { 1000 },
            animationSpec = tween(animationDuration)
        )
    }

}
