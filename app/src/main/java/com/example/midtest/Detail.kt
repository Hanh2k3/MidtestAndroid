package com.example.midtest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Detail : AppCompatActivity() {

    lateinit var edtNameD: EditText
    lateinit var edtAgeD: EditText
    lateinit var edtAddressD: EditText
    lateinit var btnUpdate: Button
    lateinit var btnDelete: Button
    var id: Int=-1
    lateinit var rs: StudentRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        edtNameD = findViewById(R.id.edtNameD)
        edtAgeD = findViewById(R.id.edtAgeD)
        edtAddressD = findViewById(R.id.edtAddressD)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)

        val i = intent
        rs = StudentRepository(application)

        edtNameD.setText(i.getStringExtra("name"))
        edtAgeD.setText(i.getIntExtra("age", -1).toString())
        edtAddressD.setText(i.getStringExtra("address"))

        id = i.getIntExtra("id", -1)


    }




}