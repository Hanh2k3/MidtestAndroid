package com.example.midtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Add : AppCompatActivity() {
    private  var edtName: EditText? = null
    private  var edtPhone: EditText? = null
    private  var edtEmail: EditText?=null
    private var btnAdd: Button?=null
    private var btnRead: Button?=null

    private  lateinit var res: StudentRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        edtName = findViewById(R.id.edtName)
        edtPhone = findViewById(R.id.edtPhone)
        edtEmail = findViewById(R.id.edtEmail)

        btnAdd = findViewById(R.id.btnAdd)
        btnRead = findViewById(R.id.btnRead)

        res = StudentRepository(application)

        btnAdd!!.setOnClickListener() {
            addStudent()
        }

        btnRead!!.setOnClickListener() {
            val i = Intent(this@Add, ListStudents::class.java)
            startActivity(i)
        }
    }

    private fun addStudent() {
        var name =  edtName!!.text.toString()
        var phone =  edtPhone!!.text.toString()
        var email =  edtEmail!!.text.toString()

        if( name ==null || phone==null || email==null) {
            Toast.makeText(this, "Vui long nhap thong tin", Toast.LENGTH_SHORT).show()
        } else {
            val checkIsNumber = isInteger(phone)
            if(checkIsNumber) {
                val student = Student(
                    edtName!!.text.toString(),
                    edtPhone!!.text.toString().toInt(),
                    edtEmail!!.text.toString(),
                )
                res!!.insert(student)
                Toast.makeText(
                    this@Add,
                    "Student has been added",
                    Toast.LENGTH_SHORT
                ).show()
                edtName!!.setText("")
                edtPhone!!.setText("")
                edtEmail!!.setText("")

            } else {
                Toast.makeText(this, "Vui long nhap so dien thoai dung dinh dang", Toast.LENGTH_SHORT).show()
            }

        }



    }
    fun isInteger(str: String?) = str?.toIntOrNull()?.let { true } ?: false
}