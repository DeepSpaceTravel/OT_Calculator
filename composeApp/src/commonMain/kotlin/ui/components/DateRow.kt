package ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.datetime.LocalDate
import ui.components.textBox.OcDateText
import ui.components.textBox.pickers.OcDatePicker
import ui.components.textBox.pickers.OcIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DateRow(
    selectedDate: LocalDate,
    onClickAction: () -> Unit,
    showDatePicker: Boolean,
    cancelAction: () -> Unit,
    confirmAction: () -> Unit,
    dismissAction: () -> Unit,
    datePickerState: DatePickerState,
    contentDescription: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OcDateText(
            selectedDate = selectedDate,
            modifier = modifier.weight(1f)
        )

        OcIconButton(
            Icons.Default.Edit,
            onClickAction = onClickAction,
            contentDescription = contentDescription,
            modifier = modifier.offset(x = 16.dp)
        ) {
            OcDatePicker(
                showDatePicker = showDatePicker,
                cancelAction = cancelAction,
                confirmAction = confirmAction,
                dismissAction = dismissAction,
                datePickerState = datePickerState
            )
        }
    }
}