package com.milk717.android.roomdbexample

import android.app.Application
import androidx.room.Room
import com.milk717.android.roomdbexample.data.MemoDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class GlobalApplication : Application() {
    companion object{
        lateinit var appInstance: GlobalApplication
            private set

        lateinit var appDataBaseInstance: MemoDataBase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this

        appDataBaseInstance = Room.databaseBuilder(
            appInstance.applicationContext,
            MemoDataBase::class.java, "memo.db"
        )
            .fallbackToDestructiveMigration()   //version 달라지면 DB 초기화
            .build()

        startKoin{
            androidContext(this@GlobalApplication)
            modules(appModule)
        }
    }
}