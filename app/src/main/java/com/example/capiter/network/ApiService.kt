package com.example.capiter.network

import com.example.capiter.network.model.Product
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("x-apikey: 87c35db9718530498e6f8be2514da8cf5989a")
    @GET("products")
    fun getProducts(@Query("q") page: String): Single<List<Product>>
}