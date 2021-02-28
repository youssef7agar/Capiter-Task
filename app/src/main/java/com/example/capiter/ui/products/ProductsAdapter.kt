package com.example.capiter.ui.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.capiter.R
import com.example.capiter.databinding.ItemProductBinding
import com.example.capiter.network.model.Product

class ProductsAdapter : ListAdapter<Product, ProductsAdapter.ViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val itemBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(product: Product) {
            itemBinding.tvProductName.text = product.name
            itemBinding.tvProductPrice.text = itemBinding.root.resources.getString(
                R.string.product_price,
                product.price.toString()
            )
            Glide.with(itemBinding.root)
                .load(product.imageUrl)
                .into(itemBinding.imgProductImage)
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return newItem == oldItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return newItem == oldItem
        }
    }
}