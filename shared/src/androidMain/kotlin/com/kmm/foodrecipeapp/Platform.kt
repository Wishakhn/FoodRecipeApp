package com.kmm.foodrecipeapp

import android.os.Parcelable
import com.kmm.foodrecipeapp.presentation.details.DetailViewModel
import com.kmm.foodrecipeapp.presentation.recipe.RecipeViewModel
import com.kmm.foodrecipeapp.presentation.welcome.WelcomeViewModel
import io.ktor.client.engine.android.Android
import kotlinx.parcelize.Parcelize
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * shared implementation of parcelable
 */
actual typealias CommonParcelable = Parcelable

actual fun sharedVMModule() = module {
    single {
        Android.create()
    }
    viewModel { WelcomeViewModel() }
    viewModel { RecipeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    /* viewModel { CCViewModel(get(), get()) }*/
}

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()