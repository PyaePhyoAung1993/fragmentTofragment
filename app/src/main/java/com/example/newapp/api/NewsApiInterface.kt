package com.example.newapp.api

import com.example.newapp.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {

    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country : String ,
        @Query("apiKey") apiKey : String
    ):Call<News>
}