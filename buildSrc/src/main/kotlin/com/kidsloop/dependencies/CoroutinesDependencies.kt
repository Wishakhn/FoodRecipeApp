
import org.gradle.api.artifacts.dsl.DependencyHandler


val coroutinesDependencies = arrayListOf<String>().apply {
    add(CoroutinesDependencies.COROUTINE_CORE)
    add(CoroutinesDependencies.COROUTINE_ANDROID)
}

object CoroutinesDependencies {
    // kotlin coroutine
    const val COROUTINE_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${CoroutinesVersion.COROUTINE_VERSION}"
    const val COROUTINE_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoroutinesVersion.COROUTINE_VERSION}"
}

fun DependencyHandler.implementCoroutineDependencies() = implementation(coroutinesDependencies)
