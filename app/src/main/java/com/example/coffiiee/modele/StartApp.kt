package com.example.coffiiee.modele

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class CoffeApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CoffeApp)
            modules(appModule)
        }
    }
}