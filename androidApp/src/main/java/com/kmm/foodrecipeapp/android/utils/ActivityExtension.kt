package com.kmm.foodrecipeapp.android.utils

import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.kmm.foodrecipeapp.base.extenssion.consume
import com.kmm.foodrecipeapp.base.interfaces.StateEffectProcessor
import kotlinx.coroutines.flow.Flow

@JvmName("OnResumedStateEffectProcessor")
fun <EV : Any, ST : Any, EF : Any> ComponentActivity.onCreated(
    processor: () -> StateEffectProcessor<EV, ST, EF>,
    intents: () -> List<Flow<EV>> = { emptyList() },
    onState: (ST) -> Unit = {},
    onEffect: (EF) -> Unit = {}
) = lifecycleScope.launchWhenCreated { this.consume(processor(), onState, onEffect, intents()) }

