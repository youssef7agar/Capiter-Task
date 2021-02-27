package com.example.capiter.ui.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capiter.R
import com.example.capiter.databinding.ActivityProductsBinding
import com.example.capiter.models.remote.Product

class ProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsBinding
    private lateinit var adapter: ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ProductsAdapter()
        binding.rvProducts.adapter = adapter
        adapter.submitList(listOf(
            Product(
                "1",
                "حلااااااااااااااااوة",
                10000,
                "https://storage.googleapis.com/capiter-storage-bucket/Product_Management/Product/1703/Documents/IMAGES/1606811631287_%D9%83%D8%B1%D8%A7%D9%86%D8%B4%D9%89%20%D9%81%D8%B1%D8%A7%D8%AE%205%D8%AC.jpg",
                1
            ),
            Product(
                "1",
                "حلااااااااااااااااوة",
                10000,
                "https://storage.googleapis.com/capiter-storage-bucket/Product_Management/Product/1703/Documents/IMAGES/1606811631287_%D9%83%D8%B1%D8%A7%D9%86%D8%B4%D9%89%20%D9%81%D8%B1%D8%A7%D8%AE%205%D8%AC.jpg",
                1
            ),
            Product(
                "1",
                "حلااااااااااااااااوة",
                10000,
                "https://storage.googleapis.com/capiter-storage-bucket/Product_Management/Product/1703/Documents/IMAGES/1606811631287_%D9%83%D8%B1%D8%A7%D9%86%D8%B4%D9%89%20%D9%81%D8%B1%D8%A7%D8%AE%205%D8%AC.jpg",
                1
            ),
            Product(
                "1",
                "حلااااااااااااااااوة",
                10000,
                "https://storage.googleapis.com/capiter-storage-bucket/Product_Management/Product/1703/Documents/IMAGES/1606811631287_%D9%83%D8%B1%D8%A7%D9%86%D8%B4%D9%89%20%D9%81%D8%B1%D8%A7%D8%AE%205%D8%AC.jpg",
                1
            )
        ))
    }
}