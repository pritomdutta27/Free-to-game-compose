package dutta.pritom.gamelist.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dutta.pritom.gamelist.domain.usecase.GetFreeToGameUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FreeToGameListViewModel @Inject constructor(private val useCase: GetFreeToGameUseCase) :
    ViewModel() {

    init {
        getFreeToGameListData()
    }

    fun getFreeToGameListData() {
        useCase.invoke().onEach {
            Log.e("getFreeToGameListData", "getFreeToGameListData: ${it}")
        }.launchIn(viewModelScope)
    }

}