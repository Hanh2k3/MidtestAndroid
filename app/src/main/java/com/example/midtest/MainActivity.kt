package com.example.midtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var res: StudentRepository
    lateinit var adapter: RvAdapter
    lateinit var rvListStudents: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        res = StudentRepository(application)
        var data: List<Student> = res.getAll() as List<Student>
        rvListStudents = findViewById(R.id.rcStudent)
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvListStudents.layoutManager = linearLayoutManager
        rvListStudents.adapter = RvAdapter(this,data,
            object : Click {
                override fun OnClick(pos: Int) {

//                    val name = data[pos].name
//                    val phone = data[pos].phone
//                    val email = data[pos].email
//                    val id = data[pos].id
//
//                    val i = Intent(this@ListStudents, Detail::class.java )
//                    i.putExtra("name", name)
//                    i.putExtra("phone", phone)
//                    i.putExtra("email", email)
//                    i.putExtra("id", id)
//                    startActivity(i)

                }
            }
        )

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.optionsmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.message -> {
                var i = Intent(this@MainActivity, Add::class.java)
                startActivity(i)
                return true
            }
        }
        return (super.onOptionsItemSelected(item))
    }


}