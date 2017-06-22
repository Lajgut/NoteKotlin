package com.bravekitty.kir.notekotlin.data

import com.bravekitty.kir.notekotlin.utils.PrefUtils



object PrefsData {

    private val LAST_ID = "last_id"

    var lastId: Long
        get() = PrefUtils.prefs.getLong(LAST_ID, 0L)
        set(lastId) {
            PrefUtils.editor.putLong(LAST_ID, lastId).commit()
        }
}