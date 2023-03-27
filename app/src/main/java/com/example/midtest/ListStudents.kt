package com.example.midtest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListStudents : AppCompatActivity() {

    lateinit var res: StudentRepository
    lateinit var adapter: UserAdapter
    lateinit var rvListStudents: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_students)

        res = StudentRepository(application)
        var data: List<Student> = res.getAll() as List<Student>

        rvListStudents = findViewById(R.id.rcStudents)

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvListStudents.layoutManager = linearLayoutManager

        rvListStudents.adapter = RvAdapter(this,data,
            object : Click {
                override fun OnClick(pos: Int) {

                    val name = data[pos].name
                    val phone = data[pos].phone
                    val email = data[pos].email
                    val id = data[pos].id

                    val i = Intent(this@ListStudents, Detail::class.java )
                    i.putExtra("name", name)
                    i.putExtra("phone", phone)
                    i.putExtra("email", email)
                    i.putExtra("id", id)
                    startActivity(i)

                }
            }
            )
    }
}