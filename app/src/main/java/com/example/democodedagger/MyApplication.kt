package com.example.democodedagger

import android.app.Application
import com.example.democodedagger.di.AppComponent
import com.example.democodedagger.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }
}