package com.example.retrofitapp


import com.google.gson.annotations.SerializedName

data class TodoListResponse(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("skip")
    val skip: Int,
    @SerializedName("todos")
    val todos: ArrayList<UserModel>,
    @SerializedName("total")
    val total: Int
)