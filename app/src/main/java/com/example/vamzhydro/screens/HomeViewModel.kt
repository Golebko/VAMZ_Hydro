package com.example.vamzhydro.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vamzhydro.data.RecordItem
import com.example.vamzhydro.data.RecordsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


data class HomeState(val itemList: List<RecordItem> = listOf())
class HomeViewModel(repository: RecordsRepository) : ViewModel() {


    val homeState: StateFlow<HomeState> = repository.getAllRecordsStream().map { HomeState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = HomeState()
        )

}

