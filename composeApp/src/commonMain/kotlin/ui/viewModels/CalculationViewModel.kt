package ui.viewModels

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.lifecycle.ViewModel
import data.database.OvertimeInfo
import data.repo.OvertimeInfoRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
class CalculationViewModel(
    private val overtimeInfoRepo: OvertimeInfoRepo
): ViewModel(){

    private val _uiState = MutableStateFlow(CalculationUiState())
    val uiState: StateFlow<CalculationUiState> = _uiState.asStateFlow()

    init {
        checkIfDateExistsAlready(uiState.value.ocDate.toString())
    }

    fun insertAnEntry() {
        overtimeInfoRepo.insertAnEntryToLocalDatabase(
            overtimeDate = uiState.value.ocDate.toString(),
            checkInTime = uiState.value.checkInTime.toString(),
            checkOutTime = uiState.value.checkOutTime.toString(),
            mealCount = uiState.value.mealCount.toLong(),
            multiplier = uiState.value.multiplier.toDouble(),
            hourlyRate = uiState.value.hourlyRate.toDouble(),
            normalWorkingLength = uiState.value.normalWorkingLength.toDouble(),
            overtimePay = uiState.value.overtimePay.toDouble(),
        )
    }

    fun showDatePicker() {
        _uiState.update { it.copy(showDatePicker = true) }
    }

    fun selectDate(datePickerState: DatePickerState) {
        val currentDate = Instant
            .fromEpochMilliseconds(datePickerState.selectedDateMillis!!)
            .toLocalDateTime(
                TimeZone.currentSystemDefault())
            .date
        _uiState.update { it.copy(
            dayAlreadyExists = overtimeInfoRepo.checkIfDateExistsAlready(currentDate.toString()),
            ocDate = currentDate)
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

    private fun checkIfDateExistsAlready(overtimeDate: String) {
        _uiState.update {
            it.copy(dayAlreadyExists = overtimeInfoRepo.checkIfDateExistsAlready(uiState.value.ocDate.toString()))
        }
    }

    fun showAlreadyAddedDialog() {
        _uiState.update { it.copy(showAlreadyAddedDialog = true) }
    }

    fun closeAlreadyAddedDialog() {
        _uiState.update { it.copy(showAlreadyAddedDialog = false) }

    }
}