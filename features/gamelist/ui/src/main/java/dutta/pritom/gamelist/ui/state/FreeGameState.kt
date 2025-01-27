package dutta.pritom.gamelist.ui.state

import dutta.pritom.gamelist.domain.model.FreeGame

 data class FreeGameState(
    val freeGameList: List<FreeGame>? = emptyList(),
    val errorMessage: String? = null,
    val isLoading: Boolean = false
 )