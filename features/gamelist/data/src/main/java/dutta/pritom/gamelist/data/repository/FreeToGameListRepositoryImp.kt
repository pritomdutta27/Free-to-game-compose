package dutta.pritom.gamelist.data.repository

import dutta.pritom.gamelist.data.datasource.remote.FreeGameApi
import dutta.pritom.gamelist.data.mapper.toFreeGame
import dutta.pritom.gamelist.domain.repository.FreeToGameListRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pritom.dutta.common.core.Resource
import javax.inject.Inject

class FreeToGameListRepositoryImp @Inject constructor(private val api: FreeGameApi) :
    FreeToGameListRepository {

    override fun fetchListFreeToGame() = flow {
        emit(Resource.Loading())
        val res = api.fetchFreeToGame().map { it.toFreeGame() }
        emit(Resource.Success(res))
    }.flowOn(IO)
        .catch {
            emit(Resource.Error(it.message))
        }
}