
import org.gradle.api.artifacts.dsl.DependencyHandler

val kotlinDependencies = arrayListOf<String>().apply {
    add(KotlinDependencies.KOTLIN_REFLECTION)
    add(KotlinDependencies.KOTLIN_STD_LIB)
}

object KotlinDependencies {
    const val KOTLIN_REFLECTION =
        "org.jetbrains.kotlin:kotlin-reflect:${KotlinVersion.STANDARD_LIBRARY}"
    const val KOTLIN_STD_LIB =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${KotlinVersion.STANDARD_LIBRARY}"
    const val KMM_MOKO = "dev.icerock.moko:mvvm-core:${KotlinVersion.MOKO}"
    const val KOTLINX_SERIALISATION = "org.jetbrains.kotlinx:kotlinx-serialization-core:${KotlinVersion.KOTLINX}"
}

fun DependencyHandler.implementKotlinDependencies() = implementation(kotlinDependencies)

