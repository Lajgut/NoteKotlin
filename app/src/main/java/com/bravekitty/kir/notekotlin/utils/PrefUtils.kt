package com.bravekitty.kir.notekotlin.utils

import android.content.Context
import android.content.SharedPreferences
import com.bravekitty.kir.notekotlin.App

object PrefUtils {

    private val PREF_NAME = "pref_name"

    val prefs: SharedPreferences
        get() = App.appComponent.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    val editor: SharedPreferences.Editor
        get() = prefs.edit()

}