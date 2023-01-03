package com.kmm.foodrecipeapp.base

import com.kmm.foodrecipeapp.base.interfaces.Effects
import com.kmm.foodrecipeapp.base.interfaces.IBaseEffects
import com.kmm.foodrecipeapp.base.interfaces.IBaseEvents
import com.kmm.foodrecipeapp.base.interfaces.IBaseStateModel
import com.kmm.foodrecipeapp.base.interfaces.Intent
import com.kmm.foodrecipeapp.base.interfaces.StateEffectProcessor
import com.kmm.foodrecipeapp.base.processors.FlowStateEffectProcessor
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<Event : IBaseEvents, State : IBaseStateModel, Effect : IBaseEffects> :
    ViewModel() {
    private val initialState: State by lazy { createInitialState() }
    private val _uiState: MutableStateFlow<State> = MutableStateFlow(initialState)
    private val uiState = _uiState.asStateFlow()
    private val currentState: State
        get() = uiState.value
    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event = _event.asSharedFlow()
    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()
    private val stateProcessor: StateEffectProcessor<Event, State, Effect> = stateEffectProcessor(
        defViewState = _uiState.value,
        prepare = { emptyFlow() },
        statesEffects = { effects, ev ->
            handleStateEvents(ev, effects)
        }
    )

    fun getStateProcessor() = stateProcessor

    abstract fun createInitialState(): State

    abstract fun handleStateEvents(event: Event, effect: Effects<Effect>): Flow<Intent<State>>

    /**
     * Set new Event
     */
    fun setEvent(event: Event) {
        val newEvent = event
        viewModelScope.launch { stateProcessor.sendEvent(newEvent) }
    }


    /**
     * Set new Ui State
     */
    protected fun setState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        _uiState.value = newState
    }

    /**
     * Set new Effect
     */
    protected fun setEffect(builder: () -> Effect) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }

    fun <EV : Any, ST : Any, PA : Intent<ST>, EF : Any> stateEffectProcessor(
        defViewState: ST,
        prepare: suspend (Effects<EF>) -> Flow<PA> = { emptyFlow() },
        statesEffects: suspend (Effects<EF>, EV) -> Flow<PA> = { _, _ -> emptyFlow() }
    ): StateEffectProcessor<EV, ST, EF> = viewModelScope.stateEffectProcessor(
        defViewState,
        prepare,
        statesEffects
    )


    fun <EV : Any, ST : Any, PA : Intent<ST>, EF : Any> CoroutineScope.stateEffectProcessor(
        defViewState: ST,
        prepare: suspend (Effects<EF>) -> Flow<PA> = { emptyFlow() },
        statesEffects: suspend (Effects<EF>, EV) -> Flow<PA> = { _, _ -> emptyFlow() },
    ): StateEffectProcessor<EV, ST, EF> =
        FlowStateEffectProcessor(this, defViewState, prepare, statesEffects)
}