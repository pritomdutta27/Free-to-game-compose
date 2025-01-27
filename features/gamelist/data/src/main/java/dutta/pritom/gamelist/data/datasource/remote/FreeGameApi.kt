package dutta.pritom.gamelist.data.datasource.remote

import dutta.pritom.gamelist.data.dto.FreeGameDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET


interface FreeGameApi {
    @GET("/api/game")
    suspend fun fetchFreeToGame(): List<FreeGameDto>
}