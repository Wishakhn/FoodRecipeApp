
import org.gradle.api.artifacts.dsl.DependencyHandler


val accompanistDependencies = arrayListOf<String>().apply {
    add(AccompanistDependencies.COIL)
    add(AccompanistDependencies.ACCOMPANIST_PAGER)
    add(AccompanistDependencies.ACCOMPANIST_UI_CONTROLLER)
    add(AccompanistDependencies.ACCOMPANIST_PAGER_INDICATOR)
    add(AccompanistDependencies.ACCOMPANIST_WEB_VIEW)
    add(AccompanistDependencies.ACCOMPANIST_PERMISSIONS)
}


object AccompanistDependencies {
    const val COIL = "io.coil-kt:coil-compose:${AccompanistVersion.COIL}"
    const val ACCOMPANIST_UI_CONTROLLER =
        "com.google.accompanist:accompanist-systemuicontroller:${AccompanistVersion.SYSTEM_UI_CONTROL}"
    const val ACCOMPANIST_PAGER =
        "com.google.accompanist:accompanist-pager:${AccompanistVersion.ACCOMPANIST_PAGER}"
    const val ACCOMPANIST_PAGER_INDICATOR =
        "com.google.accompanist:accompanist-pager-indicators:${AccompanistVersion.ACCOMPANIST_PAGER}"
    const val ACCOMPANIST_WEB_VIEW =
        "com.google.accompanist:accompanist-webview:${AccompanistVersion.WEB_VIEW}"
    const val ACCOMPANIST_PERMISSIONS =
        "com.google.accompanist:accompanist-permissions:${ComposeVersion.COMPOSE_PERMISSIONS}"
}

fun DependencyHandler.implementAccompanistDependencies() = implementation(accompanistDependencies)
