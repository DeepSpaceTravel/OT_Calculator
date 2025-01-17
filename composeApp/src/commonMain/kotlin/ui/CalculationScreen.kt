package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.DateRow
import ui.components.MealRow
import ui.components.OcMealText
import ui.components.OcTimeText
import ui.components.TimeRow
import ui.components.ocDateText
import ui.pickers.OcDatePicker
import ui.pickers.OcIconButton
import ui.pickers.OcTimePicker


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculationScreen(calculationViewModel: CalculationViewModel) {
    val calculationUiState by calculationViewModel.uiState.collectAsState()
    val datePickerState = rememberDatePickerState()
    val checkInTimePickerState = rememberTimePickerState()
    val checkOutTimePickerState = rememberTimePickerState()

    Column() {
        //TODO: Fix this bloody padding thing

        val modifier = Modifier

        DateRow(
            selectedDate = calculationUiState.ocDate,
            onClickAction = { calculationViewModel.showDatePicker() },
            showDatePicker = calculationUiState.showDatePicker,
            cancelAction = { calculationViewModel.closeDatePicker() },
            confirmAction = {
                calculationViewModel.selectDate(datePickerState = datePickerState)
                calculationViewModel.closeDatePicker()
            },
            dismissAction = { calculationViewModel.closeDatePicker() },
            datePickerState = datePickerState,
            contentDescription = "//-- Place Holder --//",
            modifier = modifier
        )
//        上班時間
        TimeRow(
            hour = calculationUiState.checkInTime.hour,
            minute = calculationUiState.checkInTime.minute,
            title = "上班時間：",
            onClickAction = { calculationViewModel.showCheckInTimePicker() },
            showTimePicker = calculationUiState.showCheckInTimePicker,
            cancelAction = { calculationViewModel.closeTimePicker() },
            confirmAction = {
                calculationViewModel.selectCheckInTime(timePickerState = checkInTimePickerState)
                calculationViewModel.closeTimePicker()
            },
            dismissAction = { calculationViewModel.closeTimePicker() },
            timePickerState = checkInTimePickerState,
            contentDescription = "//--Place Holder--//",
            modifier = modifier
        )
//        下班時間
        TimeRow(
            hour = calculationUiState.checkOutTime.hour,
            minute = calculationUiState.checkOutTime.minute,
            title = "下班時間：",
            onClickAction = { calculationViewModel.showCheckOutTimePicker() },
            showTimePicker = calculationUiState.showCheckOutTimePicker,
            cancelAction = { calculationViewModel.closeTimePicker() },
            confirmAction = {
                calculationViewModel.selectCheckOutTime(timePickerState = checkOutTimePickerState)
                calculationViewModel.closeTimePicker()
            },
            dismissAction = { calculationViewModel.closeTimePicker() },
            timePickerState = checkOutTimePickerState,
            contentDescription = "//--Place Holder--//",
            modifier = modifier
        )
        MealRow(
            iconClickedAction = { calculationViewModel.showMealPicker() },
            menuItemClickedAction = {
                //IDK why it worked but it worked
                calculationViewModel.selectMealCount(it)
                calculationViewModel.closeMealPicker()
            },
            onDismissRequest = { calculationViewModel.closeMealPicker() },
            showMealPicker = calculationUiState.showMealPicker,
            mealCount = calculationUiState.mealCount,
            modifier = modifier
        )
    }
}