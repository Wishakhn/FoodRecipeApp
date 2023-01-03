val implementClassPaths = arrayListOf<String>().apply {
    add(BuildConfigurations.ANDROID_GRADLE_PLUGIN)
    add(BuildConfigurations.KOTLIN_GRADLE_PLUGIN)
    add(BuildConfigurations.KOTLIN_SERIALISATION)
    add(BuildConfigurations.NAVIGATION_SAFE_ARGS)
    add(BuildConfigurations.JUNIT_5)
}

object BuildConfigurations {
    const val ANDROID_GRADLE_PLUGIN =
        "com.android.tools.build:gradle:${PluginVersion.BUILD_GRADLE}"
    const val KOTLIN_GRADLE_PLUGIN =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersion.KOTLIN}"
    const val NAVIGATION_SAFE_ARGS =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${PluginVersion.NAVIGATION}"
    const val KOTLIN_SERIALISATION =
        "org.jetbrains.kotlin:kotlin-serialization:${PluginVersion.SERIALISATION}"
    const val JUNIT_5 =
        "de.mannodermaus.gradle.plugins:android-junit5:${PluginVersion.JUNIT_5_GRADLE}"
}




