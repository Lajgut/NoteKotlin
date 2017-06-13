package com.bravekitty.kir.notekotlin.database

import com.bravekitty.kir.notekotlin.models.NoteModel
import com.bravekitty.kir.notekotlin.utils.PrefUtils
import io.realm.Realm


class RealmDatabase {

    private var realmInstance: Realm? = null
    private var note: NoteModel? = null
    private var lastId: Long = 0

    init {
        realmInstance = Realm.getDefaultInstance()
    }

    /**
     * add note to realm db
     */
    fun addNote(header: String, text: String, date: String, img: ByteArray?) {
        realmInstance!!.executeTransaction {
            val id = lastId + 1

            formNote(id, header, text, date, img!!)
            /**
             * save last id in prefs
             * because it may bee need to know that later
             */
            //setLastId(id)

        }
    }

    /**
     * create note object by necessary fields
     */
    private fun formNote(id: Long, header: String, text: String, date: String, img: ByteArray?) {
        note = realmInstance!!.createObject(NoteModel::class.java)
        note!!.id = id
        note!!.header = header
        note!!.text = text
        note!!.date = date
        note!!.img = img
    }

    /**
     * remove item by id
     */
    fun removeNote(id: Long?) {
        realmInstance!!.executeTransaction {

            val searchByIdResult = realmInstance!!.where(NoteModel::class.java).equalTo(NoteModel.ID, id).findAll()
            if (!searchByIdResult.isEmpty()) {
                for (i in searchByIdResult.indices.reversed()) {
                    searchByIdResult[i].deleteFromRealm()
                }
            }

        }
    }


    /*Bitmap bmp = intent.getExtras().get("data");
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
    byte[] byteArray = stream.toByteArray();*/


    /*fun getLastId(): Long {
        return PrefUtils.lastId
    }

    fun setLastId(lastId: Long) {
        PrefUtils.lastId = lastId
    }*/

    fun closeOnDestroy() {
        realmInstance!!.close()
    }
}