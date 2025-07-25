package com.example.coffiiee

import android.app.Application
import com.example.coffiiee.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class CoffeeApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CoffeeApp)
            modules(appModule)
        }
    }
}