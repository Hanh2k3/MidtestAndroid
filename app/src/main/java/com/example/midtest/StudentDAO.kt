package com.example.midtest

import androidx.room.Dao
import androidx.room.*

@Dao
interface StudentDAO {

    @Insert
    fun insert(model: Student?)


    @get:Query("SELECT * FROM students ORDER BY name ASC")
    val getAllStudents: List<Student>



}