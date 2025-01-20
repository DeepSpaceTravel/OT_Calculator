package ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun EntryListScreen(entryListScreenModel: EntryListViewModel){

    val entryListUiState by entryListScreenModel.uiState.collectAsState()

    Text("Hello World")
    Button(
        onClick = {},
        content = { Text("Yeet") })
    LazyColumn {
        items(5) { index ->
            Text("Item: $index")
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