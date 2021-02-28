package com.example.capiter.ui.products

import com.example.capiter.network.model.Product
import java.lang.Exception

data class ProductsViewState(
        val loading: Boolean = false,
        val loadingMore: Boolean = false,
        val error: Exception? = null,
        val products: List<Product> = listOf()
)