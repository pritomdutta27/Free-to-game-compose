package dutta.pritom.freetogamecompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import dutta.pritom.freetogamecompose.ui.theme.FreeToGameComposeTheme
import dutta.pritom.gamelist.ui.state.UiEffect
import dutta.pritom.gamelist.ui.viewmodel.FreeToGameListViewModel
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FreeToGameComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val viewMode = hiltViewModel<FreeToGameListViewModel>()
    viewMode.getFreeToGameListData()
    val state = viewMode.freeToGameList.collectAsStateWithLifecycle()
//    val res = viewMode.
    val snackBar = remember { SnackbarHostState() }

    LaunchedEffect(key1 = "key1") {
        viewMode.uiEffect.collectLatest {
            when(it){
                UiEffect.NavigateToDetailsScreen -> {}
                is UiEffect.ShowSnackBar -> {
                    snackBar.showSnackbar(it.message ?: "No")
                }
            }
        }
    }

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FreeToGameComposeTheme {
        Greeting("Android")
    }
}