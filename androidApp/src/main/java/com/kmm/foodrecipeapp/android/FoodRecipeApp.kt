package com.kmm.foodrecipeapp.android

import android.app.Application
import com.kmm.foodrecipeapp.base.di.initKoin
import org.koin.android.ext.koin.androidContext

class FoodRecipeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            baseUrl = "https://tasty.p.rapidapi.com",
            enableNetworkLogs = BuildConfig.DEBUG
        ) {
            androidContext(this@FoodRecipeApp)
        }
    }

}