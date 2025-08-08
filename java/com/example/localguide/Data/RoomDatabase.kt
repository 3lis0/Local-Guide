package com.example.localguide.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase




@Database(entities = [Users::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "user_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}