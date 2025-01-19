package ui.components.textBox

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString

@Composable
internal fun OcMealText(mealCount: Byte,
               modifier: Modifier) {
    Text(
        text = buildAnnotatedString {
            append("加班餐數：")
            append(mealCount.toString())
        },
        modifier = modifier
    )
}