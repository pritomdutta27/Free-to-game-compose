package dutta.pritom.gamelist.domain.usecase

import dutta.pritom.gamelist.domain.model.FreeGame
import dutta.pritom.gamelist.domain.repository.FreeToGameListRepository
import kotlinx.coroutines.flow.Flow
import pritom.dutta.common.core.Resource
import javax.inject.Inject

class GetFreeToGameUseCase @Inject constructor(private val repository: FreeToGameListRepository) {

    suspend fun getListOfFreeToGame(): Flow<Resource<List<FreeGame>>> {
        return repository.fetchListFreeToGame()
    }

}