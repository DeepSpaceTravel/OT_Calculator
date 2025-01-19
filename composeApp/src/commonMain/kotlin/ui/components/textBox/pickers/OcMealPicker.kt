package ui.components.textBox.pickers

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun OcMealPicker(
    iconClickedAction: () -> Unit,
    menuItemClickedAction: (Byte) -> Unit,
    onDismissRequest: () -> Unit,
    showMealPicker: Boolean
) {
    Box(
        modifier = Modifier
    ) {
        IconButton(onClick = iconClickedAction) {
            Icon(
                Icons.Rounded.Edit,
                contentDescription = "//Place Holder//"
            )
        }
        DropdownMenu(
            onDismissRequest = onDismissRequest,
            expanded = showMealPicker,
            content = {
                (0..2).forEach {
                    DropdownMenuItem(
                        text = { Text(text = "$it") },
                        onClick = { menuItemClickedAction(it.toByte()) }
                    )
                }
            }
        )
    }
}