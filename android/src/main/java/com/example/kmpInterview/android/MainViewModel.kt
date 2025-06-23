package com.example.kmpInterview.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmpInterview.common.api.RocketReserverApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val api: RocketReserverApi
) : ViewModel() {
    private val _launches = MutableStateFlow(Unit)
    val launches = _launches.asStateFlow()

    fun getLaunches() {
        viewModelScope.launch(Dispatchers.IO) {
            api.getLaunches().collect { launches ->
                // TODO bind API data to the UI
            }
        }
    }
}