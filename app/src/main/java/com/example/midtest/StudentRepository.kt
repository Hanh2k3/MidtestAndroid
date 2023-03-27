package com.example.midtest

import android.app.Application

class StudentRepository(var application: Application) {
    private  lateinit var  db:StudentDatabase

    init {
        db = StudentDatabase.getInstance(application)

    }
    fun insert(student: Student?) {
        db.myDao().insert(student)
    }

    fun getAll(): List<Student?>? {
        return db.myDao().getAllStudents
    }


}