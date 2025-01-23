package ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import data.EntryRepoInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EntryListViewModel(
    private val entryRepo: EntryRepoInterface
): ViewModel(){

    private val _uiState = MutableStateFlow(EntryListUiState())
    val uiState: StateFlow<EntryListUiState> = _uiState.asStateFlow()

    fun getAllInfo() {
        viewModelScope.launch {
//            _uiState.update { it.copy(overtimeInfoList = entryRepo.getAllInfoStream()) }
            println(_uiState.value.overtimeInfoList)
            println("List printed")
        }
    }

//    companion object{
//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                EntryListViewModel()
//            }
//        }
//    }
}