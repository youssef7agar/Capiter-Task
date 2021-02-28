package com.example.capiter.di

import com.example.capiter.ui.products.ProductsActivity
import dagger.Component

@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(activity: ProductsActivity)
}