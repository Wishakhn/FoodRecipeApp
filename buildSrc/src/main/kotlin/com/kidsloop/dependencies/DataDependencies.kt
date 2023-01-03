import org.gradle.api.artifacts.dsl.DependencyHandler

val androidDataDependencies = arrayListOf<String>().apply {
    add(KtorDependencies.KTOR_CLIENT)
    add(KtorDependencies.KTOR_CLIENT_AUTH)
    add(KtorDependencies.KTOR_ANDROID_CLIENT)
    add(KtorDependencies.KTOR_OKHTTP_CLIENT)
    add(KtorDependencies.KTOR_WEBSOCKETS)
    add(KtorDependencies.KTOR_SERIALIZATION_GSON)
    add(KtorDependencies.KTOR_SERIALISATION_JSON)
    add(KtorDependencies.KTOR_JVM)
    add(KtorDependencies.KTOR_CORE)
    add(KtorDependencies.KTOR_CLIENT_JSON)
    add(KtorDependencies.KTOR_SERIALISATION)
    add(KtorDependencies.KTOR_CONTENT_NEGOTIATION)
    add(KtorDependencies.KTOR_LOGGING_CLIENT)
    add(KtorDependencies.JSON)
}

object KtorDependencies {
    const val KTOR_CORE = "io.ktor:ktor-client-core:${DataVersion.KTOR_CORE}"
    const val KTOR_CLIENT_JSON = "io.ktor:ktor-client-json:${DataVersion.KTOR_CORE}"
    const val KTOR_CONTENT_NEGOTIATION =
        "io.ktor:ktor-client-content-negotiation:${DataVersion.KTOR_CORE}"
    const val JSON = "io.ktor:ktor-serialization-kotlinx-json:${DataVersion.KTOR_CORE}"
    const val KTOR_SERIALISATION = "io.ktor:ktor-client-serialization:${DataVersion.KTOR_CORE}"
    const val KTOR_ANDROID_CLIENT = "io.ktor:ktor-client-android:${DataVersion.KTOR_CLIENT_ANDROID}"
    const val KTOR_IOS_CLIENT = "io.ktor:ktor-client-ios:${DataVersion.KTOR_IOS}"

    const val KTOR_LOGGING_CLIENT = "io.ktor:ktor-client-logging:${DataVersion.KTOR_CORE}"
    const val KTOR_CLIENT = "io.ktor:ktor-client-cio:${DataVersion.KTOR_CORE}"
    const val KTOR_CLIENT_AUTH = "io.ktor:ktor-client-auth:${DataVersion.KTOR_CORE}"
    const val KTOR_OKHTTP_CLIENT =
        "io.ktor:ktor-client-okhttp:${DataVersion.KTOR_CLIENT_OKHTTP}"
    const val KTOR_WEBSOCKETS =
        "io.ktor:ktor-client-websockets:${DataVersion.KTOR_CORE}"
    const val KTOR_SERIALIZATION_GSON =
        "io.ktor:ktor-serialization-gson:${DataVersion.KTOR_CORE}"
    const val KTOR_SERIALISATION_JSON =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${DataVersion.KOTLINX_SERIALIZATION_GSON}"
    const val KTOR_DRAWN =
        "io.ktor:ktor-client-darwin:${DataVersion.KTOR_CLIENT_DARWIN}"
    const val KTOR_JVM = "io.ktor:ktor-client-logging-jvm:${DataVersion.KTOR_CORE}"
}

object LocalStorageDependencies {
    const val DATA_STORE_OKIO = "androidx.datastore:datastore-core-okio:${DataVersion.DTATA_STORE}"
    const val DATA_STORE = "androidx.datastore:datastore-preferences-core:${DataVersion.DTATA_STORE}"
    const val ANDROID_DATA_STORE = "androidx.datastore:datastore-preferences:${DataVersion.AND_DATA_STORE}"
}

fun DependencyHandler.implementKtorAndroidDependencies() = implementation(androidDataDependencies)
