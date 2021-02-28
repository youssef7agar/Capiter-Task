package com.example.capiter.network

import com.example.capiter.network.model.Product
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("products")
    fun getProducts(@Query("q") page: Int): Observable<List<Product>>
}