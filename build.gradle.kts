plugins {
    id(BuildPluginConfigs.androidApplication) apply false
    id(BuildPluginConfigs.androidLibrary) apply false
    id(BuildPluginConfigs.ksp) version PluginVersion.KSP apply false
    kotlin(BuildPluginConfigs.kotlinAndroid) apply false
    kotlin(BuildPluginConfigs.kotlinKapt) apply false
    kotlin(BuildPluginConfigs.kotlinMultiplatform) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven ( "https://jitpack.io")
    }
    dependencies {
        implementClassPaths.forEach { classPaths ->
            classpath(classPaths)
        }
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven ( "https://jitpack.io")
    }
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
subprojects {
    apply {
    }
}