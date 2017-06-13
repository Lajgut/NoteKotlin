package com.bravekitty.kir.notekotlin

import android.app.Application
import com.bravekitty.kir.notekotlin.di.AppComponent
import com.bravekitty.kir.notekotlin.di.DaggerAppComponent
import com.bravekitty.kir.notekotlin.di.modules.ContextModule
import com.bravekitty.kir.notekotlin.di.modules.DatabaseModule
import io.realm.Realm


class App : Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }



    override fun onCreate() {
        super.onCreate()

        /**
         * init realm once, at app start
         */
        Realm.init(this)

        /**
         * dagger 2 init
         */
        appComponent = DaggerAppComponent.builder()
                .contextModule(ContextModule(this@App))
                .databaseModule(DatabaseModule())
                .build()

    }
}