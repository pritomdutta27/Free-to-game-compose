package dutta.pritom.gamelist.data.datasource.remote

import dutta.pritom.gamelist.data.dto.FreeGameDto
import retrofit2.http.GET


interface FreeGameApi {
    @GET("/api/games")
    suspend fun fetchFreeToGame(): List<FreeGameDto>
}