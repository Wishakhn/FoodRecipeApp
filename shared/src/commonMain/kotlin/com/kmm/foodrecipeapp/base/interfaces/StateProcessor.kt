package com.kmm.foodrecipeapp.base.interfaces

import kotlinx.coroutines.flow.StateFlow

interface StateProcessor<in EV : Any, out ST : Any> {
    val state: StateFlow<ST>
    fun sendEvent(event: EV)
}
