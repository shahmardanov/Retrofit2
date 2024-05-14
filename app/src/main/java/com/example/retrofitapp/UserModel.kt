package com.example.retrofitapp


import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("todo")
    val todo: String,
    @SerializedName("userId")
    val userId: Int
)