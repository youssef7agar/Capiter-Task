package com.example.capiter.repository

import com.example.capiter.network.ApiService
import com.example.capiter.network.model.Product
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class Repo @Inject constructor(private val apiService: ApiService) {

    fun getProducts(page: Int): Single<List<Product>> {
        return apiService.getProducts("{\"page\":${page}}")
    }
}