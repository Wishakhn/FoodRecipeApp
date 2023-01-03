package com.kmm.foodrecipeapp.base.processors


import com.kmm.foodrecipeapp.base.extenssion.reduceAndSet
import com.kmm.foodrecipeapp.base.interfaces.Effects
import com.kmm.foodrecipeapp.base.interfaces.Intent
import com.kmm.foodrecipeapp.base.interfaces.StateEffectProcessor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class FlowStateEffectProcessor<in EV : Any, ST : Any, out PA : Intent<ST>, EF : Any> constructor(
    private val scope: CoroutineScope,
    initialState: ST,
    prepare: (suspend (Effects<EF>) -> Flow<PA>)? = null,
    private val onEvent: (suspend (Effects<EF>, EV) -> Flow<PA>)? = null,
) : StateEffectProcessor<EV, ST, EF> {

    override val effect: Flow<EF>
        get() = effectSharedFlow
    private val effectSharedFlow: MutableSharedFlow<EF> = MutableSharedFlow(replay = 0)

    override val state: StateFlow<ST>
        get() = stateFlow
    private val stateFlow: MutableStateFlow<ST> = MutableStateFlow(initialState)

    private val effectsCollector: Effects<EF> = object : Effects<EF> {
        override fun send(effect: EF) {
            scope.launch { effectSharedFlow.emit(effect) }
        }
    }

    init {
        prepare?.let {
            scope.launch {
                it(effectsCollector).collect { stateFlow.reduceAndSet(it) }
            }
        }
    }

    override fun sendEvent(event: EV) {
        onEvent?.let {
            scope.launch { it(effectsCollector, event).collect { stateFlow.reduceAndSet(it) } }
        }
    }
}
