package ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class EntryListViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(EntryListUiState())
    val uiState: StateFlow<EntryListUiState> = _uiState.asStateFlow()

    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                EntryListViewModel()
            }
        }
    }
}