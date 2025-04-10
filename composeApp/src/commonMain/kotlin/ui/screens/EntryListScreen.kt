package ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ot_calculator.composeapp.generated.resources.Res
import ot_calculator.composeapp.generated.resources.check_in_time
import ot_calculator.composeapp.generated.resources.check_out_time
import ui.components.textBox.OcDateText
import ui.components.textBox.OcMealText
import ui.components.textBox.OcTimeText
import ui.viewModels.EntryListViewModel

@Composable
fun EntryListScreen(
    modifier: Modifier = Modifier
) {

    val entryListViewModel: EntryListViewModel = koinViewModel<EntryListViewModel>()
    val entryListUiState by entryListViewModel.uiState.collectAsState()

    println(entryListUiState.entryList.size)

    if (entryListUiState.entryList.isNotEmpty()) {
        LazyColumn(
            modifier = modifier) {
            items(
                entryListUiState.entryList.size
            ) { index ->
                val entry = entryListUiState.entryList[index]
                EntryCard(
                    selectedDate = LocalDate.parse(entry.overtime_date),
                    checkInTime = LocalTime.parse(entry.check_in_time),
                    checkOutTime = LocalTime.parse(entry.check_out_time),
                    mealCount = entry.meal_count!!.toByte(),
                    modifier = modifier
                )
            }
        }
    }
    else{
//        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Ayo boi you don't have any entry",
            )
//        }
    }
}

@Composable
private fun EntryCard(
    selectedDate: LocalDate,
    checkInTime: LocalTime,
    checkOutTime: LocalTime,
    mealCount: Byte,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
    ){
        Column(modifier = modifier) {
//                Date
            OcDateText(
                selectedDate = selectedDate
            )

//                Check in Time
            OcTimeText(
                title = stringResource(Res.string.check_in_time),
                hourAndMinute = checkInTime,
            )

//                Check out Time
            OcTimeText(
                title = stringResource(Res.string.check_out_time),
                hourAndMinute = checkOutTime,
            )

//                Meal Count
            OcMealText(
                mealCount = mealCount
            )

//                Horizontal Divider
            HorizontalDivider()

//                Overtime pay
            Row {
//                Total Text
                Text(
                    text = "Total",
                )
//                Figure
                Text(
                    text = "Figure"
                )
            }
        }
    }
}