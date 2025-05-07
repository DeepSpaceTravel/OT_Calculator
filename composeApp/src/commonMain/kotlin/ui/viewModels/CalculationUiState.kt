package ui.viewModels

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class CalculationUiState(
    val ocDate: LocalDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date,
    val checkInTime: LocalTime = LocalTime(hour = 8, minute = 0),
    val checkOutTime: LocalTime = LocalTime(hour = 17, minute = 15),
    val mealCount: Byte = 0,
    val multiplier: Float = 1.5f,
    val hourlyRate: Float = 1.0f,
    val normalWorkingLength: Float = 8.0f,
    val overtimePay: Float = 0f,
    val dayAlreadyExists: Boolean = false,
    val showDatePicker: Boolean = false,
    val showCheckInTimePicker: Boolean = false,
    val showCheckOutTimePicker: Boolean = false,
    val showMealPicker: Boolean = false,
    val showAlreadyAddedDialog: Boolean = false,


)