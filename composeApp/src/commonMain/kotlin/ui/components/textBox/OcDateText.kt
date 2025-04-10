package ui.components.textBox

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import kotlinx.datetime.LocalDate
import org.jetbrains.compose.resources.stringResource
import ot_calculator.composeapp.generated.resources.Res
import ot_calculator.composeapp.generated.resources.selected_date_is

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun OcDateText(selectedDate: LocalDate,
               modifier: Modifier = Modifier) {

    //Main text content
    Text(
        text = buildAnnotatedString {
            append(stringResource(Res.string.selected_date_is))
            append(selectedDate.toString())
            append(" (")
            append(selectedDate.dayOfWeek.toString().take(3))
            append(")")
        },
        modifier = modifier
    )
}