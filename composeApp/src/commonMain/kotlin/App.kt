import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.screens.CalculationScreen
import ui.screens.EntryListScreen
import ui.components.TopBar
import ui.navigation.Routes

@Composable
@Preview
fun App(
    navController: NavHostController = rememberNavController()
) {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            tonalElevation = 20.dp
        ) {
            var showContent by remember { mutableStateOf(false) }
            Column(
                Modifier
                    .fillMaxWidth().windowInsetsPadding(WindowInsets.statusBars),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                Button(onClick = { showContent = !showContent }) {
//                    Text("Click me!")
//                }
//                AnimatedVisibility(showContent) {
//                    val greeting = remember { Greeting().greet() }
//                    Column(
//                        Modifier.fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Image(painterResource(Res.drawable.compose_multiplatform), null)
//                        Text("Compose: $greeting")
//                    }
//                }

                TopBar(
                    onMenuClick = { navController.navigate(route = Routes.EntryList.name) },
                    navController = navController
                )

                NavHost(
                    navController = navController,
                    startDestination = Routes.Home.name
                ) {
                    composable(route = Routes.Home.name) {
                        CalculationScreen()
                    }
                    composable(route = Routes.EntryList.name) {
                        EntryListScreen()
                    }
                }
            }
        }
    }
}