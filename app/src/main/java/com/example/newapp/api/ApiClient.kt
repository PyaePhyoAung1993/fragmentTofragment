package com.example.newapp.api

import com.example.newapp.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient{

    private val BASE_URL = "https://newsapi.org/v2/"

    val apiInterface : NewsApiInterface

    init {
       var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInterface = retrofit.create(
            NewsApiInterface::class.java

        )
    }
//    fun getTopHeadlines() : Call<News> {
//        return apiInterface.getTopHeadlines(
//            "us","87c2c97411e14a1fa22f202e7a49cc86"
//        )
//    }
    fun getTopHeadlines() : Call<News> {
    return apiInterface.getTopHeadlines(
        "us","87c2c97411e14a1fa22f202e7a49cc86"
    )
}
}