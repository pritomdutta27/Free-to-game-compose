package dutta.pritom.gamelist.domain.model

data class FreeGame(
    val freeToGameProfileUrl: String,
    val gameUrl: String,
    val genre: String,
    val id: Int,
    val title: String,
    val shortDescription: String,
)
