package ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ui.HourAndMinute
import ui.components.textBox.OcTimeText
import ui.components.textBox.pickers.OcIconButton
import ui.components.textBox.pickers.OcTimePicker

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TimeRow(
    hour: Byte,
    minute: Byte,
    title: String,
    onClickAction: () -> Unit,
    showTimePicker: Boolean,
    cancelAction: () -> Unit,
    confirmAction: () -> Unit,
    dismissAction: () -> Unit,
    timePickerState: TimePickerState,
    contentDescription: String,
    modifier: Modifier
){
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically){
        OcTimeText(
            title = title,
            hourAndMinute = HourAndMinute(hour = hour, minute = minute),
            modifier = modifier.weight(1f)
        )

        OcIconButton(
            Icons.Default.Edit,
            onClickAction = onClickAction,
            contentDescription = contentDescription
        ){
            OcTimePicker(
                showTimePicker = showTimePicker,
                cancelAction = cancelAction,
                confirmAction = confirmAction,
                dismissAction = dismissAction,
                timePickerState = timePickerState
            )
        }
    }
}