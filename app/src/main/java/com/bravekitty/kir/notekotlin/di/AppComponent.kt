package com.bravekitty.kir.notekotlin.di

import android.content.Context
import com.bravekitty.kir.notekotlin.di.modules.ContextModule
import com.bravekitty.kir.notekotlin.di.modules.DatabaseModule
import com.bravekitty.kir.notekotlin.ui.acitvities.EditorActivity
import com.bravekitty.kir.notekotlin.ui.acitvities.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ContextModule::class, DatabaseModule::class))
interface AppComponent {
    val context: Context

    fun inject(mainActivity: MainActivity)

    fun inject(editorActivity: EditorActivity)
}