package com.kmm.foodrecipeapp.android.utils

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.kmm.foodrecipeapp.base.extenssion.consume
import com.kmm.foodrecipeapp.base.interfaces.StateEffectProcessor
import com.kmm.foodrecipeapp.base.interfaces.StateProcessor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun <EV : Any, ST : Any, EF : Any> onStateConsumed(
    processor: () -> StateEffectProcessor<EV, ST, EF>,
    intents: () -> List<Flow<EV>> = { emptyList() },
    onState: (ST) -> Unit = {},
    onEffect: (EF) -> Unit = {}
) {
    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        consume(processor(), onState, onEffect, intents())
    }
}

@SuppressLint("FlowOperatorInvokedInComposition", "StateFlowValueCalledInComposition")
@Composable
fun <EV : Any, ST : Any, T> StateProcessor<EV, ST>.collectAsState(
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    mapper: (ST) -> T
): State<T> {
    val flow = state.map { mapper(it) }.distinctUntilChanged()
    val lifecycleOwner = LocalLifecycleOwner.current
    return remember(flow, lifecycleOwner) {
        flow.flowWithLifecycle(lifecycleOwner.lifecycle, lifecycleState)
    }.collectAsState(initial = mapper(state.value))
}