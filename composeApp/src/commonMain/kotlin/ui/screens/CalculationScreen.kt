package ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ot_calculator.composeapp.generated.resources.Res
import ot_calculator.composeapp.generated.resources.check_in_time
import ot_calculator.composeapp.generated.resources.check_out_time
import ui.components.DateRow
import ui.components.MealRow
import ui.components.TimeRow
import ui.viewModels.CalculationViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculationScreen(

) {

    val calculationViewModel: CalculationViewModel = koinViewModel<CalculationViewModel>()
    val calculationUiState by calculationViewModel.uiState.collectAsState()

    val datePickerState = rememberDatePickerState()
    val checkInTimePickerState = rememberTimePickerState()
    val checkOutTimePickerState = rememberTimePickerState()

    val basicPadding = 16.dp
    val modifier = Modifier
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(basicPadding)
    ) {
        //TODO: Fix this bloody padding thing
        Column {
            Row {  }
        }
        DateRow(
            selectedDate = calculationUiState.ocDate,
            onClickAction = { calculationViewModel.showDatePicker() },
            showDatePicker = calculationUiState.showDatePicker,
            cancelAction = { calculationViewModel.closeDatePicker() },
            confirmAction = {
                calculationViewModel.selectDate(datePickerState = datePickerState)
                calculationViewModel.closeDatePicker() },
            dismissAction = { calculationViewModel.closeDatePicker() },
            datePickerState = datePickerState,
            contentDescription = "//-- Place Holder --//",
            modifier = modifier
        )
//       上班時間
        TimeRow(
            hour = calculationUiState.checkInTime.hour.toByte(),
            minute = calculationUiState.checkInTime.minute.toByte(),
            title = stringResource(Res.string.check_in_time),
            onClickAction = { calculationViewModel.showCheckInTimePicker() },
            showTimePicker = calculationUiState.showCheckInTimePicker,
            cancelAction = { calculationViewModel.closeTimePicker() },
            confirmAction = {
                calculationViewModel.selectCheckInTime(timePickerState = checkInTimePickerState)
                calculationViewModel.closeTimePicker() },
            dismissAction = { calculationViewModel.closeTimePicker() },
            timePickerState = checkInTimePickerState,
            contentDescription = "//--Place Holder--//",
            modifier = modifier
        )
//       下班時間
        TimeRow(
            hour = calculationUiState.checkOutTime.hour.toByte(),
            minute = calculationUiState.checkOutTime.minute.toByte(),
            title = stringResource(Res.string.check_out_time),
            onClickAction = { calculationViewModel.showCheckOutTimePicker() },
            showTimePicker = calculationUiState.showCheckOutTimePicker,
            cancelAction = { calculationViewModel.closeTimePicker() },
            confirmAction = {
                calculationViewModel.selectCheckOutTime(timePickerState = checkOutTimePickerState)
                calculationViewModel.closeTimePicker() },
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
                calculationViewModel.closeMealPicker() },
            onDismissRequest = { calculationViewModel.closeMealPicker() },
            showMealPicker = calculationUiState.showMealPicker,
            mealCount = calculationUiState.mealCount,
            modifier = modifier
        )
        HorizontalDivider()
        Text("Working Length: ")
        Text("Total:")

        Button(
            onClick = {},
            modifier = modifier.fillMaxWidth()
        ){
            Text("Submit")
        }
    }
}