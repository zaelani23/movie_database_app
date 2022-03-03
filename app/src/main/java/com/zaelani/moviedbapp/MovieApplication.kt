package com.zaelani.moviedbapp

import android.app.Application
import com.zaelani.moviedbapp.core.di.databaseModule
import com.zaelani.moviedbapp.core.di.networkModule
import com.zaelani.moviedbapp.core.di.repositoryModule
import com.zaelani.moviedbapp.di.useCaseModule
import com.zaelani.moviedbapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.NONE)
            androidContext(this@MovieApplication)
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
    }
}