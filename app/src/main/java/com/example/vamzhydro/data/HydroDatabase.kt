package com.example.vamzhydro.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Record::class], version = 1, exportSchema = false)
abstract class HydroDatabase : RoomDatabase() {

    abstract fun recordDao(): RecordDao

    companion object {
        @Volatile
        private var Instance: HydroDatabase? = null

        fun getDatabase(context: Context): HydroDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, HydroDatabase::class.java, "record_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}