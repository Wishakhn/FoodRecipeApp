package com.kmm.foodrecipeapp

import org.koin.core.module.Module


expect fun sharedVMModule(): Module
expect interface CommonParcelable

@OptIn(ExperimentalMultiplatform::class)
@OptionalExpectation
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
expect annotation class CommonParcelize()

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform