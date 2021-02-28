package com.example.capiter.di

import com.example.capiter.di.products.ProductsViewModelModule
import com.example.capiter.ui.products.ProductsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [ProductsViewModelModule::class])
    abstract fun contributeProductsActivity(): ProductsActivity
}