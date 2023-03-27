package com.example.midtest

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "students")
class Student(
    name: String,
    phone: Int,
    email: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var name: String = name
    var phone: Int = phone
    var email: String = email
}
