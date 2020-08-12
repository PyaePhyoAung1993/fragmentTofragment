package com.example.newapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newapp.api.ApiClient
import com.example.newapp.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel(){

    private val result : MutableLiveData<News> = MutableLiveData()
    private var errorMessage : MutableLiveData<String> = MutableLiveData()
    private var errorStatus : MutableLiveData<Boolean> = MutableLiveData()
    private var loading : MutableLiveData<Boolean> = MutableLiveData()

    fun getResult() : LiveData<News> = result

    fun getErrorMessage() : LiveData<String> = errorMessage

    fun getErrorStatus() : LiveData<Boolean> = errorStatus

    fun getLoading() : LiveData<Boolean> = loading



    fun loadResult(){
        var apiClient = ApiClient()
        var apiCall = apiClient.getTopHeadlines()

        apiCall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
//                txt.text = t.toString()

                loading.value = false
                errorStatus.value = true
                errorMessage.value = t.toString()
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
//                t1.text = response.body()?.articles.toString()
                result.value = response.body()

                loading.value = false
                errorStatus.value = true




            }
        })
    }

}