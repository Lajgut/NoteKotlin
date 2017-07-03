package com.bravekitty.kir.notekotlin.models

import io.realm.RealmObject


open class NoteModel (
        /**
     * note id
     */
    var id: Long = 0L,
        /**
     * mainText header
     */
    var header: String? = null,

        /**
     * main mainText
     */
    var mainText: String = "",

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
                    ) : RealmObject() {
    companion object {
        val ID = "id"
    }
}