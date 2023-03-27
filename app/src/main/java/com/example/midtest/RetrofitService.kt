package com.example.midtest

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    private val gson = GsonBuilder().create()
    fun create(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = (HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit
    }
}