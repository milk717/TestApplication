package com.milk717.android.koinexample

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class GlobalApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@GlobalApplication)
        }
    }
}