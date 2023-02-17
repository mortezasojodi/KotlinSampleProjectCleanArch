package com.example.msanewmusicui

import android.app.Application
import com.example.msanewmusicui.core.di.databaseModule
import com.example.msanewmusicui.core.di.networkModule
import com.example.msanewmusicui.core.di.repositoryModule
import com.example.msanewmusicui.di.useCaseModule
import com.example.msanewmusicui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}