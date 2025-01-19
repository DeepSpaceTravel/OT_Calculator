package ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class EntryListScreen: Screen {

    @Composable
    override fun Content() {
//        TODO("Not yet implemented")
        Text("Hello World")

        val navigator = LocalNavigator.currentOrThrow
        Button(
            onClick = {
            navigator.pop()
            },
            content = { Text("Yeet") })
    }
}