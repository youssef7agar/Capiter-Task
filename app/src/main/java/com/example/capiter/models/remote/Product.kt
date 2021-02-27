package com.example.capiter.models.remote

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("image-url")
    val imageUrl: String,
    @SerializedName("page")
    val page: Int
)