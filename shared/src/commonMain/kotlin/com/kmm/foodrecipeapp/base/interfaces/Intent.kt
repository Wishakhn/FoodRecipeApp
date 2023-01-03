package com.kmm.foodrecipeapp.base.interfaces

interface Intent<T> {
    fun reduce(oldState: T): T
}
