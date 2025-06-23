package com.example.kmpInterview.android.di

import com.example.kmpInterview.android.MainViewModel
import org.koin.core.module.dsl.new
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel { new(::MainViewModel) }
}