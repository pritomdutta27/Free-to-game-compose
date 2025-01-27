package dutta.pritom.gamelist.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dutta.pritom.gamelist.domain.usecase.GetFreeToGameUseCase
import dutta.pritom.gamelist.ui.state.FreeGameState
import dutta.pritom.gamelist.ui.state.UiEffect
import dutta.pritom.gamelist.ui.state.UiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pritom.dutta.common.core.Resource
import javax.inject.Inject

@HiltViewModel
class FreeToGameListViewModel @Inject constructor(private val useCase: GetFreeToGameUseCase) :
    ViewModel() {

    private val _freeToGameList = MutableStateFlow(FreeGameState())
    val freeToGameList: StateFlow<FreeGameState>
        get() = _freeToGameList

    private val _uiEffect = MutableSharedFlow<UiEffect>()
    val uiEffect: SharedFlow<UiEffect>
        get() = _uiEffect

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent>
        get() = _uiEvent


    fun getFreeToGameListData() {
        useCase.invoke().onEach {
            when (it) {
                is Resource.Error -> {
                    _freeToGameList.value = FreeGameState().copy(errorMessage = it.message)
                    _uiEffect.emit(UiEffect.ShowSnackBar(it.message))
                }

                is Resource.Loading -> {
                    _freeToGameList.value = FreeGameState().copy(isLoading = true)
                }

                is Resource.Success -> {
                    _freeToGameList.value = FreeGameState().copy(freeGameList = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            UiEvent.NavigateToDetailsScreen -> {

            }
        }
    }

}