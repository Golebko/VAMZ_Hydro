package com.example.vamzhydro

import android.app.Application
import com.example.vamzhydro.data.Container
import com.example.vamzhydro.data.DataContainer

class HydroApplication: Application() {

    lateinit var container: Container

    override fun onCreate() {
        super.onCreate()
        container = DataContainer(this)
    }
}