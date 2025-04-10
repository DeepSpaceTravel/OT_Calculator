package ui.screens

import androidx.compose.material3.Text
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import androidx.compose.ui.test.*
import data.database.OvertimeInfo
import kotlin.test.Test

class EntryListScreenTest {


//    companion object {
//        val sampleData = listOf(
//            OvertimeInfo(
//                deleted = 0,
//                overtime_date = TODO(),
//                check_in_time = TODO(),
//                check_out_time = TODO(),
//                meal_count = TODO(),
//                multiplier = TODO(),
//            ),
//            OvertimeInfo(
//                deleted = 0,
//                overtime_date = TODO(),
//                check_in_time = TODO(),
//                check_out_time = TODO(),
//                meal_count = TODO(),
//                multiplier = TODO(),
//            )
//        )
//    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun shouldDisplayCards() = runComposeUiTest {
        setContent {
            Text("HELLO TEST")
        }

        onNodeWithText("HELLO TEST").assertTextContains("HELLO")
    }
}