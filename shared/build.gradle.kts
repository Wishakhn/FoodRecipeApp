plugins {
    id(BuildPluginConfigs.androidLibrary)
    kotlin(BuildPluginConfigs.kotlinMultiplatform)
    kotlin(BuildPluginConfigs.nativeCocoPods)
    kotlin(BuildPluginConfigs.kotlinSerialise)
    id(BuildPluginConfigs.kotlinParcelize)
}

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    kotlin.targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java) {

        // export correct artifact to use all classes of library directly from Swift

        binaries.withType(org.jetbrains.kotlin.gradle.plugin.mpp.Framework::class.java).all {
            export("dev.icerock.moko:mvvm-core:0.13.1")
        }

        binaries.all {
            binaryOptions["memoryModel"] = "experimental"
        }
    }
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                with(KtorDependencies) {
                    implementation(KTOR_CORE)
                    implementation(KTOR_CLIENT_JSON)
                    implementation(KTOR_SERIALISATION)
                    implementation(KTOR_CONTENT_NEGOTIATION)
                    implementation(KTOR_LOGGING_CLIENT)
                    implementation(JSON)
                }
                with(DiDependencies) {
                    implementation(KOIN_CORE)
                }
                with(KotlinDependencies) {
                    implementation(KOTLIN_REFLECTION)
                    implementation(KOTLIN_STD_LIB)
                    implementation(KOTLINX_SERIALISATION)
                }
                with(LocalStorageDependencies) {
                    implementation(DATA_STORE)
                    implementation(DATA_STORE_OKIO)
                }
                with(CoroutinesDependencies) {
                    implementation(COROUTINE_CORE)
                }
                api(KotlinDependencies.KMM_MOKO)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                with(KtorDependencies) {
                    implementation(KTOR_CLIENT)
                    implementation(KTOR_CLIENT_AUTH)
                    implementation(KTOR_ANDROID_CLIENT)
                    implementation(KTOR_OKHTTP_CLIENT)
                    implementation(KTOR_WEBSOCKETS)
                    implementation(KTOR_SERIALIZATION_GSON)
                    implementation(KTOR_SERIALISATION_JSON)
                    implementation(KTOR_JVM)
                }
                with(DiDependencies) {
                    implementation(KOIN)
                    implementation(KOIN_COMPOSE)
                    implementation(KOIN_ANDROID_COMPAT)
                    implementation(KOIN_NAVIGATION)
                }
                with(CoroutinesDependencies) {
                    implementation(COROUTINE_ANDROID)
                }
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(TestDependencies.COROUTINES)
                implementation(TestDependencies.KOIN_TEST_JUNIT5)
                implementation(TestDependencies.KOIN_TEST)
                implementation(TestDependencies.JUPITER)
                implementation(TestDependencies.JUPITER_PARAM)
                implementation(TestDependencies.JUPITER_ENGINE)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies {
                implementation(KtorDependencies.KTOR_IOS_CLIENT)
                implementation(KtorDependencies.KTOR_DRAWN)
            }
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = AppConfiguration.SHARED_APP_ID
    compileSdk = AppConfiguration.COMPILE_SDK_VERSION
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = AppConfiguration.MIN_SDK_VERSION
        targetSdk = AppConfiguration.TARGET_SDK_VERSION
    }
}