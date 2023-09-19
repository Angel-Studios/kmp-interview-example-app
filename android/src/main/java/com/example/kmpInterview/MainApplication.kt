package com.example.kmpInterview

import android.app.Application
import com.example.kmpInterview.di.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.example.kmpInterview.di.commonModule

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(androidModule, commonModule)
        }
    }
}