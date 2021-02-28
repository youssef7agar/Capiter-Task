package com.example.capiter.ui.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capiter.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsBinding
    private lateinit var adapter: ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ProductsAdapter()
        binding.rvProducts.adapter = adapter
    }
}