package com.kmm.foodrecipeapp.base.interfaces

interface Effects<T : Any> {
    fun send(effect: T)
}
