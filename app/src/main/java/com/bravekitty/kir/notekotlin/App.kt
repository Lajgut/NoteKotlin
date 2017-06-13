package com.bravekitty.kir.notekotlin

import android.app.Application
import com.bravekitty.kir.notekotlin.di.AppComponent
import com.bravekitty.kir.notekotlin.di.DaggerAppComponent
import com.bravekitty.kir.notekotlin.di.modules.ContextModule
import io.realm.Realm


class App : Application() {

    companion object {
<<<<<<< HEAD
        internal var appComponent: AppComponent? = null
=======
        public var appComponent: AppComponent? = null
>>>>>>> master
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
                .build()

    }
}