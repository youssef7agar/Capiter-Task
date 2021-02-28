package com.example.capiter.network

import com.example.capiter.BuildConfig
import com.example.capiter.network.model.Product
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("x-apikey: ${BuildConfig.API_KEY}")
    @GET("products")
    fun getProducts(@Query("q") page: String): Single<List<Product>>
}