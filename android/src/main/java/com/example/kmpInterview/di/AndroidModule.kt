package com.example.kmpInterview.di

import com.example.kmpInterview.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel {
        MainViewModel(
            api = get()
        )
    }
}