package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import ui.components.DateRow
import ui.components.MealRow
import ui.components.TimeRow


@OptIn(ExperimentalMaterial3Api::class)
class CalculationScreen(): Screen {

    @Composable
    override fun Content() {
        val calculationScreenModel = rememberScreenModel { CalculationScreenModel()}
        val calculationUiState by calculationScreenModel.uiState.collectAsState()


        val datePickerState = rememberDatePickerState()
        val checkInTimePickerState = rememberTimePickerState()
        val checkOutTimePickerState = rememberTimePickerState()


        val paddingOffset = 0.dp
        val columnPadding = PaddingValues(start = paddingOffset + 16.dp, end = paddingOffset)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(columnPadding)
        ) {

            //TODO: Fix this bloody padding thing
            val modifier = Modifier.fillMaxWidth()

            DateRow(
                selectedDate = calculationUiState.ocDate,
                onClickAction = { calculationScreenModel.showDatePicker() },
                showDatePicker = calculationUiState.showDatePicker,
                cancelAction = { calculationScreenModel.closeDatePicker() },
                confirmAction = {
                    calculationScreenModel.selectDate(datePickerState = datePickerState)
                    calculationScreenModel.closeDatePicker()
                },
                dismissAction = { calculationScreenModel.closeDatePicker() },
                datePickerState = datePickerState,
                contentDescription = "//-- Place Holder --//",
                modifier = modifier
            )
//        上班時間
            TimeRow(
                hour = calculationUiState.checkInTime.hour,
                minute = calculationUiState.checkInTime.minute,
                title = "上班時間：",
                onClickAction = { calculationScreenModel.showCheckInTimePicker() },
                showTimePicker = calculationUiState.showCheckInTimePicker,
                cancelAction = { calculationScreenModel.closeTimePicker() },
                confirmAction = {
                    calculationScreenModel.selectCheckInTime(timePickerState = checkInTimePickerState)
                    calculationScreenModel.closeTimePicker()
                },
                dismissAction = { calculationScreenModel.closeTimePicker() },
                timePickerState = checkInTimePickerState,
                contentDescription = "//--Place Holder--//",
                modifier = modifier
            )
//        下班時間
            TimeRow(
                hour = calculationUiState.checkOutTime.hour,
                minute = calculationUiState.checkOutTime.minute,
                title = "下班時間：",
                onClickAction = { calculationScreenModel.showCheckOutTimePicker() },
                showTimePicker = calculationUiState.showCheckOutTimePicker,
                cancelAction = { calculationScreenModel.closeTimePicker() },
                confirmAction = {
                    calculationScreenModel.selectCheckOutTime(timePickerState = checkOutTimePickerState)
                    calculationScreenModel.closeTimePicker()
                },
                dismissAction = { calculationScreenModel.closeTimePicker() },
                timePickerState = checkOutTimePickerState,
                contentDescription = "//--Place Holder--//",
                modifier = modifier
            )
            MealRow(
                iconClickedAction = { calculationScreenModel.showMealPicker() },
                menuItemClickedAction = {
                    //IDK why it worked but it worked
                    calculationScreenModel.selectMealCount(it)
                    calculationScreenModel.closeMealPicker()
                },
                onDismissRequest = { calculationScreenModel.closeMealPicker() },
                showMealPicker = calculationUiState.showMealPicker,
                mealCount = calculationUiState.mealCount,
                modifier = modifier
            )
        }
    }
}