package scripts

import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.gradle.internal.dsl.BaseFlavor
import com.android.build.gradle.internal.dsl.BuildType
import java.util.*

fun BaseFlavor.buildConfigBoolean(name: String, value: Boolean) =
    buildConfigField("Boolean", name, value.toString())

fun ApplicationProductFlavor.buildConfigString(name: String, value: String) =
    buildConfigField("String", name, "\"$value\"")

fun BuildType.buildConfigString(name: String, value: String) =
    buildConfigField("String", name, "\"$value\"")

fun decodeBase64(encodedString: String): String =
    Base64.getDecoder().decode(encodedString).toString(Charsets.UTF_8)