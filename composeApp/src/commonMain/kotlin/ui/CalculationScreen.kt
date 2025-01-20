package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ui.components.DateRow
import ui.components.MealRow
import ui.components.TimeRow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculationScreen(
    calculationViewModel: CalculationViewModel = viewModel(factory = CalculationViewModel.Factory),
    navController: NavHostController = rememberNavController()
) {

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
            hour = calculationUiState.checkInTime.hour,
            minute = calculationUiState.checkInTime.minute,
            title = "上班時間：",
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
            hour = calculationUiState.checkOutTime.hour,
            minute = calculationUiState.checkOutTime.minute,
            title = "下班時間：",
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
        Button(
            onClick = {},
            modifier = modifier.fillMaxWidth()
        ){
            Text("Submit")
        }
    }
}