package com.bravekitty.kir.notekotlin.utils

import android.content.Context
import android.content.SharedPreferences
import com.bravekitty.kir.notekotlin.App

object PrefUtils {
    private val PREF_NAME = "pref_name"
    private val LAST_ID = "last_id"

    val prefs: SharedPreferences
        get() = App.appComponent.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    val editor: SharedPreferences.Editor
        get() = prefs.edit()

    var lastId: Long
        get() = prefs.getLong(LAST_ID, 0L)
        set(lastId) {
            editor.putLong(LAST_ID, lastId).commit()
        }
}