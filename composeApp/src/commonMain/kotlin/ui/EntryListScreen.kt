package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun EntryListScreen(
    entryListViewModel: EntryListViewModel = viewModel(factory = EntryListViewModel.Factory),
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
){

    val entryListUiState by entryListViewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text("Hello World")
        Button(
            onClick = onBackClick,
            content = { Text("Yeet") })

        EntryCard()

        LazyColumn {
            items(5) { index ->
                Text("Item: ${index+1}")
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
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(12.dp)
    ){
        Row(modifier = modifier) {
//            Text row
            Column(modifier = modifier.weight(1f)) {
                Text("THICC")
            }

//            Figures row
            Column(modifier = modifier) {
                Text("smoll")
            }
        }
    }
}