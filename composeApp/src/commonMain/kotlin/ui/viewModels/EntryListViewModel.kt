package ui.viewModels

import androidx.lifecycle.ViewModel
import data.repo.OvertimeInfoRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.datetime.LocalDate

class EntryListViewModel(
    private val overtimeInfoRepo: OvertimeInfoRepo
): ViewModel() {

    private val _uiState = MutableStateFlow(EntryListUiState())
    val uiState: StateFlow<EntryListUiState> = _uiState.asStateFlow()

    init {
        getAllInfo()
    }

    private fun getAllInfo() {
        _uiState.update { it.copy(entryList = overtimeInfoRepo.getLocalData().sortedWith(compareBy { overtimeInfo -> LocalDate.parse(overtimeInfo.overtime_date) }).reversed()) }
    }
}