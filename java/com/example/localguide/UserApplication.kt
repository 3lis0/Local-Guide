package com.example.localguide

import android.app.Application
import com.example.localguide.Data.AppContainer
import com.example.localguide.Data.AppDataContainer


class UserApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}