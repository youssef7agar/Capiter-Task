package com.example.capiter.di.products

import androidx.lifecycle.ViewModel
import com.example.capiter.di.ViewModelKey
import com.example.capiter.ui.products.ProductsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProductsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProductsViewModel::class)
    abstract fun bindProductsViewModel(viewModel: ProductsViewModel?): ViewModel?
}