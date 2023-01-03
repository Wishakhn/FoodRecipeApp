package com.kmm.foodrecipeapp.base.extenssion

import com.kmm.foodrecipeapp.base.interfaces.EffectProcessor
import com.kmm.foodrecipeapp.base.interfaces.StateEffectProcessor
import com.kmm.foodrecipeapp.base.interfaces.StateProcessor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

fun <EV : Any, ST : Any> CoroutineScope.consume(
    processor: StateProcessor<EV, ST>,
    render: (ST) -> Unit,
    viewEvents: List<Flow<EV>> = emptyList()
) {
    launch { processor.onState(render) }
    launch { processor.process(viewEvents) }
}

fun <EV : Any, EF : Any, ST : Any> CoroutineScope.consume(
    processor: StateEffectProcessor<EV, ST, EF>,
    render: (ST) -> Unit,
    trigger: (EF) -> Unit,
    viewEvents: List<Flow<EV>> = emptyList()
) {
    launch { processor.onState(render) }
    launch { processor.onEffect(trigger) }
    launch { processor.process(viewEvents) }
}

fun <EV : Any, EF : Any> CoroutineScope.consume(
    processor: EffectProcessor<EV, EF>,
    trigger: (EF) -> Unit,
    viewEvents: List<Flow<EV>> = emptyList()
) {
    launch { processor.onEffect(trigger) }
    launch { processor.process(viewEvents) }
}

suspend fun <EV : Any, ST : Any> StateProcessor<EV, ST>.process(
    viewEvents: List<Flow<EV>> = emptyList()
) = viewEvents.mergeEvents().collect { event -> sendEvent(event) }

 suspend fun <EV : Any, EF : Any> EffectProcessor<EV, EF>.process(
    viewEvents: List<Flow<EV>> = emptyList()
) = viewEvents.mergeEvents().collect { event -> sendEvent(event) }

 suspend fun <EV : Any, ST : Any> StateProcessor<EV, ST>.onState(
    render: (ST) -> Unit
): FlowCollector<ST> = state.collect { state -> render(state) }

 suspend fun <EV : Any, ST : Any, EF : Any> StateEffectProcessor<EV, ST, EF>.onEffect(
    trigger: (EF) -> Unit
) = effect.collect { effect -> trigger(effect) }

internal suspend fun <EV : Any, EF : Any> EffectProcessor<EV, EF>.onEffect(
    trigger: (EF) -> Unit
) = effect.collect { effect -> trigger(effect) }
