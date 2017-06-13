package com.bravekitty.kir.notekotlin.models

import io.realm.RealmObject


class NoteModel (
    /**
     * note id
     */
    var id: Long = 0L,
    /**
     * text header
     */
    var header: String? = null,

    /**
     * main text
     */
    var text: String = "",

    /**
     * photo, if added by user
     */
    var img: ByteArray? = null,

    /**
     * date of creating note
     */
    var date: String = ""

    /**
     * constant ID for query by RealmDB
     */
                    ) /*: RealmObject()*/ {
    companion object {
        val ID = "id"
    }
}