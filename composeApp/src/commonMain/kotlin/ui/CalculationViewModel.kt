@file:OptIn(ExperimentalMaterial3Api::class)

package ui

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
//class CalculationViewModel: ViewModel (){

class CalculationScreenModel: ScreenModel {
    private val _uiState = MutableStateFlow(CalculationUiState())
    val uiState: StateFlow<CalculationUiState> = _uiState.asStateFlow()

    fun showDatePicker() {
        _uiState.update { it.copy(showDatePicker = true) }
    }

    fun selectDate(datePickerState: DatePickerState) {
        _uiState.update { it
            .copy(ocDate = Instant
                .fromEpochMilliseconds(datePickerState.selectedDateMillis!!)
                .toLocalDateTime(
                    TimeZone.currentSystemDefault())
                .date
            )
        }
    }

    fun closeDatePicker() {
        _uiState.update { it.copy(showDatePicker = false) }
    }

    fun showCheckInTimePicker() {
        _uiState.update { it.copy(showCheckInTimePicker = true) }
    }

    fun selectCheckInTime(timePickerState: TimePickerState) {
        _uiState.update { it.copy(checkInTime = HourAndMinute(hour = timePickerState.hour.toByte(), minute = timePickerState.minute.toByte())) }
    }

    fun showCheckOutTimePicker() {
        _uiState.update { it.copy(showCheckOutTimePicker = true) }
    }

    fun selectCheckOutTime(timePickerState: TimePickerState) {
        _uiState.update { it.copy(checkOutTime = HourAndMinute(hour = timePickerState.hour.toByte(), minute = timePickerState.minute.toByte())) }
    }

    fun closeTimePicker() {
        _uiState.update { it.copy(showCheckInTimePicker = false, showCheckOutTimePicker = false) }
    }

    fun showMealPicker() {
        _uiState.update { it.copy(showMealPicker = true) }
    }

    fun selectMealCount(mealCount: Byte) {
        _uiState.update { it.copy(mealCount = mealCount)}
    }

    fun closeMealPicker() {
        _uiState.update { it.copy(showMealPicker = false) }
    }
}