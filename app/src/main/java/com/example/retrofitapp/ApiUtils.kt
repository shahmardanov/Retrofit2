package com.example.retrofitapp

class ApiUtils {
    companion object {
        fun createApi(): ApiManager {
            return RetrofitClient.retrofit.create(ApiManager::class.java)
        }


    }
}