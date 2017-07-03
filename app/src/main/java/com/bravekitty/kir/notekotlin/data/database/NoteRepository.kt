package com.bravekitty.kir.notekotlin.data.database

import android.util.Log
import com.bravekitty.kir.notekotlin.data.PrefsData
import com.bravekitty.kir.notekotlin.models.NoteModel
import io.realm.Realm
import io.realm.RealmResults




class NoteRepository {

    private var realmInstance: Realm = Realm.getDefaultInstance()
    private var note: NoteModel? = null
    private var lastId
    get() = PrefsData.lastId
    set(lastId) {
        PrefsData.lastId = lastId
    }

    /**
     * add note to realm db
     */
    fun addNote(header: String, text: String, date: String, img: ByteArray?) {
        realmInstance.executeTransaction {
            val id = lastId + 1

            formNote(id, header, text, date, img)

            /**
             * increment last id and save it
             */
            lastId = id

            Log.d("realm", "note added")
        }
    }

    /**
     * create note object by necessary fields
     */
    private fun formNote(id: Long, header: String, text: String, date: String, img: ByteArray?) {
        note = realmInstance.createObject(NoteModel::class.java)
        note!!.id = id
        note!!.header = header
        note!!.mainText = text
        note!!.date = date
        note?.img = img
    }

    /**
     * remove item by id
     */
    fun removeNote(id: Long?) {
        realmInstance.executeTransaction {

            val searchByIdResult = realmInstance.where(NoteModel::class.java).equalTo(NoteModel.ID, id).findAll()
            if (!searchByIdResult.isEmpty()) {
                for (i in searchByIdResult.indices.reversed()) {
                    searchByIdResult[i].deleteFromRealm()
                }
            }

        }
    }

    //todo сделать запрос по количеству записей, при скролле
    fun findAll() : RealmResults<NoteModel> {
        val results = realmInstance.where(NoteModel::class.java).findAll()
        return results
    }

    /**
     * prepare photo for saving into realm
     */
    /*Bitmap bmp = intent.getExtras().get("data");
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
    byte[] byteArray = stream.toByteArray();*/

    fun closeOnDestroy() {
        realmInstance.close()
    }
}