package dutta.pritom.gamelist.domain.repository

import dutta.pritom.gamelist.domain.model.FreeGame
import kotlinx.coroutines.flow.Flow
import pritom.dutta.common.core.Resource

interface FreeToGameListRepository {
    fun fetchListFreeToGame(): Flow<Resource<List<FreeGame>>>
}