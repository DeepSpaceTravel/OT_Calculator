package ui.viewModels

import data.database.OvertimeInfo

data class EntryListUiState(
    val entryList: List<OvertimeInfo> = emptyList()
)

data class EntryList(
    val entryList: List<OvertimeInfo> = emptyList()
)
