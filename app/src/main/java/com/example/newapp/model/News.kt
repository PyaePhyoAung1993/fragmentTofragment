package com.example.newapp.model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)