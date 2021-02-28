package com.example.capiter.common

import android.app.Application
import com.example.capiter.di.AppComponent
import com.example.capiter.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
                .build()
    }

    companion object {
        @JvmStatic
        lateinit var component: AppComponent
    }
}