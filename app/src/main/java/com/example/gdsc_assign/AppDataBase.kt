package com.example.gdsc_assign

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gdsc_assign.RoomData.ToDo
import com.example.gdsc_assign.RoomData.ToDoDao

@Database(entities = [ToDo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null)
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "todoDB"
                    )
                        .build()
                }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }
    }
}

