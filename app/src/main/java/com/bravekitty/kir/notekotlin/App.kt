package com.bravekitty.kir.notekotlin

import android.app.Application
import com.bravekitty.kir.notekotlin.di.AppComponent
import com.bravekitty.kir.notekotlin.di.DaggerAppComponent
import com.bravekitty.kir.notekotlin.di.modules.ContextModule


class App : Application() {

    companion object {
        private var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .contextModule(ContextModule(this@App))
                .build()

    }
}