
import org.gradle.api.artifacts.dsl.DependencyHandler

val jetPackComposeDependencies = arrayListOf<String>().apply {
    add(ComposeDependencies.COMPOSE_UI)
    add(ComposeDependencies.COMPOSE_UI_TOOLING)
    add(ComposeDependencies.COMPOSE_MATERIAL)
    add(ComposeDependencies.COMPOSE_MATERIAL_CORE)
    add(ComposeDependencies.COMPOSE_MATERIAL_EXTENDED)
    add(ComposeDependencies.COMPOSE_ANDROID)
    add(ComposeDependencies.COMPOSE_LIVEDATA)
    add(ComposeDependencies.COMPOSE_ACTIVITY)
    add(ComposeDependencies.COMPOSE_CONSTRAINT_LAYOUT)
    add(ComposeDependencies.COMPOSE_NAVIGATION)
    add(ComposeDependencies.COMPOSE_PAGER)
    add(ComposeDependencies.COMPOSE_PAGER_INDICATORS)
    add(ComposeDependencies.COMPOSE_VIEW_MODEL)
    add(ComposeDependencies.COMPOSE_DIMENSSIONS)
    add(ComposeDependencies.COMPOSE_SPLASH)
    add(ComposeDependencies.COMPOSE_DESTINATIONS)
    add(ComposeDependencies.COMPOSE_NAV_ANIMATION)
    //add(ComposeDependencies.COMPOSE_NAV_KSP)
    add(ComposeDependencies.COMPOSE_COMPILER)
}

object ComposeDependencies {
    const val COMPOSE_UI = "androidx.compose.ui:ui:${ComposeVersion.COMPOSE_UI}"
    const val COMPOSE_COMPILER = "androidx.compose.runtime:runtime:${ComposeVersion.COMPOSE_UI}"
    // Tooling support (Previews, etc.)
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${ComposeVersion.COMPOSE_UI_TOOLING}"
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    const val COMPOSE_ANDROID = "androidx.compose.foundation:foundation:${ComposeVersion.COMPOSE_FOUNDATION}"
    // Material Design
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${ComposeVersion.COMPOSE_MATERIAL}"
    // Material design icons
    const val COMPOSE_MATERIAL_CORE = "androidx.compose.material:material-icons-core:${ComposeVersion.COMPOSE_MATERIAL_CORE}"
    const val COMPOSE_MATERIAL_EXTENDED = "androidx.compose.material:material-icons-extended:${ComposeVersion.COMPOSE_MATERIAL_EXTENDED}"
    // Integration with observablesComposeDependenciesVersions
    const val COMPOSE_LIVEDATA = "androidx.compose.runtime:runtime-livedata:${ComposeVersion.COMPOSE_LIVEDATA}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${ComposeVersion.COMPOSE_ACTIVITY}"
    const val COMPOSE_CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout-compose:${ComposeVersion.COMPOSE_CONSTRAINT_LAYOUT}"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${ComposeVersion.COMPOSE_NAVIGATION}"
    const val COMPOSE_PAGER = "com.google.accompanist:accompanist-pager:0.25.1"
    const val COMPOSE_PAGER_INDICATORS = "com.google.accompanist:accompanist-pager-indicators:0.25.0"
    const val COMPOSE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:${ComposeVersion.COMPOSE_VIEW_MODEL}"
    const val COMPOSE_DIMENSSIONS = "com.github.Kaaveh:sdp-compose:${ComposeVersion.COMPOSE_DIMEN}"
    const val COMPOSE_SPLASH = "androidx.core:core-splashscreen:${ComposeVersion.COMPOSE_SPLASH}"
    const val COMPOSE_DESTINATIONS = "io.github.raamcosta.compose-destinations:core:${ComposeVersion.COMPOSE_DESTINATION}"
    const val COMPOSE_NAV_ANIMATION = "io.github.raamcosta.compose-destinations:animations-core:${ComposeVersion.COMPOSE_DESTINATION}"
    const val COMPOSE_NAV_KSP = "io.github.raamcosta.compose-destinations:ksp:${ComposeVersion.COMPOSE_DESTINATION}"
}

fun DependencyHandler.implementComposeDependencies() = implementation(jetPackComposeDependencies)


