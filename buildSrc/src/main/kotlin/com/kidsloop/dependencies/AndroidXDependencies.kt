
import org.gradle.api.artifacts.dsl.DependencyHandler

val androidXDependencies = arrayListOf<String>().apply {
    add(AndroidXDependencies.APPCOMPAT)
    add(AndroidXDependencies.ACTIVITY_KTX)
    add(AndroidXDependencies.VECTOR_DRAWABLE)
    add(AndroidXDependencies.VECTOR_DRAWABLE_ANIMATED)
    add(AndroidXDependencies.MATERIAL)
    add(AndroidXDependencies.WEB_KIT)
    add(AndroidXDependencies.LIFE_CYCLE_KTX)
    add(AndroidXDependencies.CORE_KTX)
    add(AndroidXDependencies.LIFECYCLE_EXTENSIONS)
    add(AndroidXDependencies.Collection_KTX)
    add(AndroidXDependencies.VIEW_MODEL_KTX)
    add(AndroidXDependencies.VIEW_MODEL_SAVE_STATE_KTX)
    add(AndroidXDependencies.LIVEDATA_KTX)
    add(AndroidXDependencies.LIFECYCLE_RUNTIME)
    add(AndroidXDependencies.LIFECYCLE_RUNTIME_KTX)
    add(AndroidXDependencies.LIFECYCLE_COMMON_JAVA)
    add(AndroidXDependencies.REACTIVE_STREAMS)

}


object AndroidXDependencies {
    const val APPCOMPAT = "androidx.appcompat:appcompat:${AndroidXVersion.APPCOMPAT}"
    const val ACTIVITY_KTX =
        "androidx.activity:activity-ktx:${AndroidXVersion.ACTIVITY_KTX_VERSION}"
    const val VECTOR_DRAWABLE =
        "androidx.vectordrawable:vectordrawable:${AndroidXVersion.VECTOR_DRAWABLE_VERSION}"
    const val VECTOR_DRAWABLE_ANIMATED =
        "androidx.vectordrawable:vectordrawable-animated:${AndroidXVersion.VECTOR_DRAWABLE_VERSION}"
    const val MATERIAL = "com.google.android.material:material:${AndroidXVersion.MATERIAL}"
    const val LIFE_CYCLE_KTX =
        "androidx.lifecycle:lifecycle-runtime-ktx:${AndroidXVersion.LIFE_CYCLE_KTX}"
    const val CORE_KTX = "androidx.core:core-ktx:${AndroidXVersion.CORE_KTX}"
    const val LIFECYCLE_EXTENSIONS =
        "androidx.lifecycle:lifecycle-extensions:${AndroidXVersion.LIFECYCLE_EXTENSIONS}"
    const val Collection_KTX =
        "androidx.collection:collection-ktx:${AndroidXVersion.Collection_KTX}"
    const val VIEW_MODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${AndroidXVersion.LIFECYCLE}"
    const val VIEW_MODEL_SAVE_STATE_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${AndroidXVersion.LIFECYCLE}"
    const val LIVEDATA_KTX =
        "androidx.lifecycle:lifecycle-livedata-ktx:${AndroidXVersion.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME =
        "androidx.lifecycle:lifecycle-runtime:${AndroidXVersion.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME_KTX =
        "androidx.lifecycle:lifecycle-runtime-ktx:${AndroidXVersion.LIFECYCLE}"
    const val LIFECYCLE_COMMON_JAVA =
        "androidx.lifecycle:lifecycle-common-java8:${AndroidXVersion.LIFECYCLE}"
    const val REACTIVE_STREAMS =
        "androidx.lifecycle:lifecycle-reactivestreams-ktx:${AndroidXVersion.LIFECYCLE}"
    const val WEB_KIT = "androidx.webkit:webkit:${AndroidXVersion.WEB_KIT}"
}

fun DependencyHandler.implementAndroidXDependencies() = implementation(androidXDependencies)

