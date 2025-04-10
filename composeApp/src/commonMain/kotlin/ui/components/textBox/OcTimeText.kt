package ui.components.textBox

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import kotlinx.datetime.LocalTime

@Composable
internal fun OcTimeText(
    title: String,
    hourAndMinute: LocalTime,
    modifier: Modifier = Modifier
) {

    var hourStr = hourAndMinute.hour.toString()
    var minuteStr = hourAndMinute.minute.toString()

    //    Check the length of Hour and Minute
    if (hourStr.length == 1) {
        hourStr = StringBuilder()
            .append("0")
            .append(hourStr)
            .toString()
    }
    if (minuteStr.length == 1) {
        minuteStr = StringBuilder()
            .append("0")
            .append(minuteStr)
            .toString()
    }

    Text(
        text = buildAnnotatedString {
            append(title)
            append(hourStr)
            append(":")
            append(minuteStr)
        },
        modifier = modifier
    )
}