package com.example.retrofitapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiManager {

    @GET("todos")
    fun getUser(): Call<TodoListResponse>

    @GET("todos/{id}")
    fun getUserById(@Path("id") id: String): Call<UserModel>

}