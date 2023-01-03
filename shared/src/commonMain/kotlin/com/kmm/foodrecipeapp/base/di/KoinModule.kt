package com.kmm.foodrecipeapp.base.di

import com.kmm.foodrecipeapp.data.details.IRDDataSource
import com.kmm.foodrecipeapp.data.details.IRecipeDetailApi
import com.kmm.foodrecipeapp.data.details.RecipeDetailImpl
import com.kmm.foodrecipeapp.data.details.RecipeDetailService
import com.kmm.foodrecipeapp.data.recipe.FoodRecipeImpl
import com.kmm.foodrecipeapp.data.recipe.FoodRecipeService
import com.kmm.foodrecipeapp.data.recipe.IFRDataSource
import com.kmm.foodrecipeapp.data.recipe.IFoodRecipeApi
import com.kmm.foodrecipeapp.domain.usecases.DetailUseCase
import com.kmm.foodrecipeapp.domain.usecases.RecipeUseCase
import com.kmm.foodrecipeapp.sharedVMModule
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


fun initKoin(
    enableNetworkLogs: Boolean = false,
    baseUrl: String,
    appDeclaration: KoinAppDeclaration = {}
) =
    startKoin {
        appDeclaration()
        modules(commonModule(enableNetworkLogs = enableNetworkLogs, baseUrl))
    }

// called by iOS etc
fun initKoin(baseUrl: String) = initKoin(enableNetworkLogs = true, baseUrl) {}


fun commonModule(enableNetworkLogs: Boolean, baseUrl: String) =
    getUseCaseModule() + getDateModule(
        enableNetworkLogs,
        baseUrl
    ) + sharedVMModule()


fun getDateModule(enableNetworkLogs: Boolean, baseUrl: String) = module {
    single<IFoodRecipeApi> {
        FoodRecipeService(
            get(), baseUrl
        )
    }
    single<IRecipeDetailApi> {
        RecipeDetailService(
            get(), baseUrl
        )
    }
    single<IFRDataSource> { FoodRecipeImpl(get()) }
    single<IRDDataSource> { RecipeDetailImpl(get()) }

    single { createJson() }

    single {
        createHttpClient(
            get(),
            get(),
            enableNetworkLogs = enableNetworkLogs
        )
    }


}

fun getUseCaseModule() = module {
    single {
        RecipeUseCase(get())
    }
    single {
        DetailUseCase(get())
    }
}


fun createHttpClient(
    httpClientEngine: HttpClientEngine,
    json: Json,
    enableNetworkLogs: Boolean
) =
    HttpClient(httpClientEngine) {


        install(ContentNegotiation) {
            json(json)
        }
        if (enableNetworkLogs) {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        }
    }

fun createJson() = Json {
    isLenient = true;
    ignoreUnknownKeys = true
}

