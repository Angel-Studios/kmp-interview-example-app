package com.example.kmpInterview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmpInterview.api.RocketReserverApi
import com.example.kmpInterview.model.Launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val api: RocketReserverApi
) : ViewModel() {
    private val _launches = MutableStateFlow<List<Launch>>(emptyList())
    val launches: StateFlow<List<Launch>> = _launches

    fun getLaunches() {
        viewModelScope.launch(Dispatchers.IO) {
            api.getLaunches().collect { launches ->
                _launches.value = launches
            }
        }
    }
}