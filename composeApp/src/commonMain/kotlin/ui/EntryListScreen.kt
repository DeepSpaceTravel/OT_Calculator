package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun EntryListScreen(
    entryListViewModel: EntryListViewModel = viewModel(factory = EntryListViewModel.Factory),
    navController: NavController
){

    val entryListUiState by entryListViewModel.uiState.collectAsState()

    Column {
        Text("Hello World")
        Button(
            onClick = { navController.navigateUp() },
            content = { Text("Yeet") })
        LazyColumn {
            items(5) { index ->
                Text("Item: $index")
            }
        }
    }
}

@Composable
private fun EntryList(
    modifier: Modifier
){
}
@Composable
private fun EntryCard(
    modifier: Modifier
) {
    Card(
        modifier = modifier
    ){
    }
}