package dutta.pritom.gamelist.ui.state

sealed class UiEffect {
    class ShowSnackBar(val message: String?) : UiEffect()
    data object NavigateToDetailsScreen : UiEffect()
}