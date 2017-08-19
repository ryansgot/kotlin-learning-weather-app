package com.fsryan.example.weatherapp

import android.app.Application
import com.fsryan.example.weatherapp.extensions.DelegatesExt

class App : Application() {
    companion object {
        var instance: App  by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}