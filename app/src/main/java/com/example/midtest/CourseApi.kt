package com.example.midtest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
interface CourseApi {
    @GET("todos")
    fun getAllCourses(): Call<List<User>>
}

