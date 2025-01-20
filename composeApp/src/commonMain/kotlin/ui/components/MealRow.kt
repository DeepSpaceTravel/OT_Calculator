package ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.textBox.OcMealText
import ui.components.textBox.pickers.OcMealPicker

@Composable
internal fun MealRow(
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
            showMealPicker = showMealPicker,
            modifier = modifier.offset(x = 16.dp)
        )
    }
}