package com.example.midtest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = arrayOf(Student::class),
    version = 2,
    exportSchema = false)
abstract class StudentDatabase: RoomDatabase() {
    abstract  fun myDao(): StudentDAO

    companion object{
        @Volatile
        private var INSTANCE: StudentDatabase? = null
        fun getInstance(context: Context): StudentDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabase::class.java, "students"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}