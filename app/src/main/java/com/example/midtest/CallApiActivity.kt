package com.example.midtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class CallApiActivity : AppCompatActivity() {

    lateinit var rvCourses: RecyclerView
    private  lateinit var adapter: UserAdapter
    private  lateinit var rvStudents: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_api)

        rvCourses = findViewById(R.id.rvCourses)
        val retrofit = RetrofitService.create()
        val service = retrofit.create(CourseApi::class.java)

        val call = service.getAllCourses()
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if(response.isSuccessful) {
                    val listCourse = response.body()
                    var data = mutableListOf<User>()
                    for (item in listCourse!!) {
                        data.add(item)
                    }
                    adapter = UserAdapter(this@CallApiActivity, data)
                    rvStudents = findViewById(R.id.rvCourses)
                    rvStudents.adapter = adapter
                    rvStudents.layoutManager = LinearLayoutManager(this@CallApiActivity)

                }
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })

    }
}