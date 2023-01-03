
import org.gradle.api.artifacts.dsl.DependencyHandler

val diDependencies = arrayListOf<String>().apply {
    add(DiDependencies.KOIN_CORE)
    add(DiDependencies.KOIN_KTOR_LOGGER)
    add(DiDependencies.KOIN_KTOR)
}
val androidDiDependencies = arrayListOf<String>().apply {
    add(DiDependencies.KOIN_COMPOSE)
    add(DiDependencies.KOIN_ANDROID_COMPAT)
    add(DiDependencies.KOIN_NAVIGATION)
}
object DiDependencies {
    const val KOIN = "io.insert-koin:koin-android:${KoinVersion.KOIN_ANDROID}"
    const val KOIN_COMPOSE = "io.insert-koin:koin-androidx-compose:${KoinVersion.KOIN_COMPOSE}"
    const val KOIN_ANDROID_COMPAT = "io.insert-koin:koin-android-compat:${KoinVersion.KOIN_ANDROID}"
    const val KOIN_CORE = "io.insert-koin:koin-core:${KoinVersion.KOIN}"
    const val KOIN_KTOR = "io.insert-koin:koin-ktor:${KoinVersion.KOIN_KTOR}"
    const val KOIN_KTOR_LOGGER = "io.insert-koin:koin-logger-slf4j:${KoinVersion.KOIN_KTOR}"
    const val KOIN_NAVIGATION = "io.insert-koin:koin-androidx-navigation:${KoinVersion.KOIN_ANDROID}"
}

fun DependencyHandler.implementDiDependencies() = implementation(androidDiDependencies)
