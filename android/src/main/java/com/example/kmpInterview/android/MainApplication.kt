package com.example.kmpInterview.android

import android.app.Application
import com.example.kmpInterview.android.di.androidModule
import com.example.kmpInterview.common.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(androidModule, commonModule)
        }
    }
}