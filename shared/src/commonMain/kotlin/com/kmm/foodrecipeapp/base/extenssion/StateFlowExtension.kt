package com.kmm.foodrecipeapp.base.extenssion

import com.kmm.foodrecipeapp.base.interfaces.Intent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf

fun <T : Intent<K>, K : Any> MutableStateFlow<K>.reduceAndSet(intent: T) {
    value = intent.reduce(value)
}

fun <T : Any> NoAction(): Intent<T> = object : Intent<T> {
    override fun reduce(oldState: T): T = oldState
}

fun <T : Any> Any.thenNoAction(): Flow<Intent<T>> = flowOf(NoAction())
