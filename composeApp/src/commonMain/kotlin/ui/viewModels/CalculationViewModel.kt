package ui.viewModels

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
class CalculationViewModel(
//    private val overtimeInfoRepo: OvertimeInfoRepo
): ViewModel(){

    private val _uiState = MutableStateFlow(CalculationUiState())
    val uiState: StateFlow<CalculationUiState> = _uiState.asStateFlow()

    init {
        getAllInfo()
    }

    private fun getAllInfo() {
//        println(overtimeInfoRepo.getLocalData().toString())
    }

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
        _uiState.update { it.copy(checkInTime = LocalTime(hour = timePickerState.hour, minute = timePickerState.minute)) }
    }

    fun showCheckOutTimePicker() {
        _uiState.update { it.copy(showCheckOutTimePicker = true) }
    }

    fun selectCheckOutTime(timePickerState: TimePickerState) {
        _uiState.update { it.copy(checkOutTime = LocalTime(hour = timePickerState.hour, minute = timePickerState.minute)) }
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