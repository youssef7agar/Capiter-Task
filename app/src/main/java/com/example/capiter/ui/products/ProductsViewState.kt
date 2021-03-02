package com.example.capiter.ui.products

import com.example.capiter.network.model.Product
import java.lang.Exception

data class ProductsViewState(
        val loading: Boolean = false,
        val loadingMore: Boolean = false,
        val error: Exception? = null,
        val products: MutableList<Product> = mutableListOf()
) {
    fun addProducts(list: List<Product>): ProductsViewState {
        products.addAll(list)
        return ProductsViewState(products = products)
    }
}