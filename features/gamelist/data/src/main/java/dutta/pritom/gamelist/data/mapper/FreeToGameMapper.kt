package dutta.pritom.gamelist.data.mapper

import dutta.pritom.gamelist.data.dto.FreeGameDto
import dutta.pritom.gamelist.domain.model.FreeGame

fun FreeGameDto.toFreeGame(): FreeGame {
    return FreeGame(
        freeToGameProfileUrl = this.freeToGameProfileUrl,
        gameUrl = this.gameUrl,
        genre = this.genre,
        id = this.id,
        title = this.title,
        shortDescription = this.shortDescription
    )
}