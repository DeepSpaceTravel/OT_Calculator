package ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ui.pickers.OcMealPicker

@Composable
fun MealRow(
    iconClickedAction: () -> Unit,
    menuItemClickedAction: (Byte) -> Unit,
    onDismissRequest: () -> Unit,
    showMealPicker: Boolean,
    mealCount: Byte,
    modifier: Modifier
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ){
        OcMealText(
            mealCount = mealCount,
            modifier = modifier.weight(1f)
        )
        // Meal Picker
        OcMealPicker(
            iconClickedAction = iconClickedAction,
            menuItemClickedAction = menuItemClickedAction,
            onDismissRequest = onDismissRequest,
            showMealPicker = showMealPicker
        )
    }
}