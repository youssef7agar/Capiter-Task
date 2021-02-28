package com.example.capiter.di

import com.example.capiter.ui.products.ProductsActivity
import com.example.capiter.ui.products.ProductsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(activity: ProductsActivity)
    fun inject(viewModel: ProductsViewModel)
}