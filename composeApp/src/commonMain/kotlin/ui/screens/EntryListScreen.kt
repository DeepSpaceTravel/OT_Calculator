package ui.screens

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
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import ui.viewmodels.EntryListViewModel

@Composable
fun EntryListScreen(
    entryListViewModel: EntryListViewModel = koinViewModel(),
    modifier: Modifier = Modifier
){

    val entryListUiState by entryListViewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text("Hello World")

        EntryCard()

        LazyColumn {
            items(5) { index ->
                Text("Item: ${index+1}")
            }
        }
        Button(onClick = {entryListViewModel.getAllInfo()}){
            Text("get Info")
        }
    }
}

@Composable
private fun EntryList(
    modifier: Modifier
){
}

@Composable
@Preview
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