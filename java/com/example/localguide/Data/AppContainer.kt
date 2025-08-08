package com.example.localguide.Data

import android.content.Context


//val context = LocalContext.current

interface AppContainer {
    val dataRepository: DataRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val dataRepository: DataRepository by lazy {
        OfflineDataRepository(AppDatabase.getDatabase(context).UserDao())
    }
}
