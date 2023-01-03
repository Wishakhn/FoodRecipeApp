package com.kmm.foodrecipeapp

import com.kmm.foodrecipeapp.presentation.details.DetailViewModel
import com.kmm.foodrecipeapp.presentation.recipe.RecipeViewModel
import com.kmm.foodrecipeapp.presentation.welcome.WelcomeViewModel
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module
import platform.UIKit.UIDevice

actual interface CommonParcelable

actual fun sharedVMModule() = module {
    single {
        Darwin.create()
    }
    single {
        WelcomeViewModel()
    }
    single {
        RecipeViewModel(get())
    }
    single {
        DetailViewModel(get())
    }
}

class IOSPlatform : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()