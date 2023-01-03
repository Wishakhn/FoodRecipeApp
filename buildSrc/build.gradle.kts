import Build_gradle.Dependencies.KOTLIN

object Dependencies {
    const val GRADLE_ANDROID = "4.1.0"
    const val GRADLE_VERSIONS = "0.33.0"
    const val KOTLIN = "1.7.10"
    const val ANDROID_BUILD = "7.2.1"
    const val NAVIGATION = "2.3.0"
    const val JACOCO = "0.16.0"
    const val DOKKA = "0.10.0"

    const val AndroidBuildTools = "com.android.tools.build:gradle:$ANDROID_BUILD"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN"
}

plugins {
    `kotlin-dsl`// binary plugin
    `kotlin-dsl-precompiled-script-plugins` // pre compiled plugin
}

repositories {
    mavenCentral()
    google()
    maven("https://jitpack.io")
    gradlePluginPortal()
}
dependencies {
    implementation(Dependencies.AndroidBuildTools)
    implementation(Dependencies.kotlinGradlePlugin)
    implementation(kotlin("gradle-plugin", KOTLIN))
}
