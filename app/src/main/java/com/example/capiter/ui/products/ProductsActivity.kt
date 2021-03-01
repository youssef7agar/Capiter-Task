package com.example.capiter.ui.products

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.capiter.R
import com.example.capiter.databinding.ActivityProductsBinding
import com.example.capiter.di.ViewModelProviderFactory
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ProductsActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private val viewModel: ProductsViewModel by viewModels { factory }

    private lateinit var binding: ActivityProductsBinding
    private lateinit var adapter: ProductsAdapter
    private var loadingMore = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ProductsAdapter()
        binding.rvProducts.adapter = adapter

        binding.refreshLayout.setOnRefreshListener {
            viewModel.refresh()
            binding.refreshLayout.isRefreshing = false
        }

        viewModel.viewState.observe(this, { productsViewState ->
            when {
                productsViewState.loading -> {
                    binding.pb.visibility = View.VISIBLE
                    binding.rvProducts.visibility = View.GONE
                }
                productsViewState.loadingMore -> {
                    binding.pbMore.visibility = View.VISIBLE
                }
                productsViewState.error != null -> {
                    binding.pb.visibility = View.GONE
                    binding.rvProducts.visibility = View.GONE
                    Snackbar.make(
                        binding.root,
                        resources.getString(R.string.error_swipe_to_refresh),
                        Snackbar.LENGTH_LONG
                    ).show()
                    Log.e(
                        "Products Activity",
                        "onCreate: fetching data error",
                        productsViewState.error
                    )
                }
                else -> {
                    loadingMore = false
                    binding.pb.visibility = View.GONE
                    binding.pbMore.visibility = View.GONE
                    binding.rvProducts.visibility = View.VISIBLE
                    adapter.submitList(productsViewState.products.toMutableList())
                }
            }
        })

        binding.scrollView.viewTreeObserver.addOnScrollChangedListener {
            try {
                val diff =
                    binding.rvProducts.bottom - (binding.scrollView.height + binding.scrollView.scrollY)
                if (diff == 0 && binding.rvProducts.bottom != 0 && !loadingMore) {
                    viewModel.getProducts()
                    loadingMore = true
                }
            } catch (e: Exception) {
                Log.e("Products Activity", "onCreate: pagination error", e)
            }
        }
    }
}