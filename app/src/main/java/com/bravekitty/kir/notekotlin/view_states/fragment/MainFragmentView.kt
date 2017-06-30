package com.bravekitty.kir.notekotlin.view_states.fragment

import com.bravekitty.kir.notekotlin.base_component.BaseView
import com.bravekitty.kir.notekotlin.models.NoteModel
import io.realm.RealmResults

interface MainFragmentView : BaseView {

    fun initNotesData(notesList: RealmResults<NoteModel>)


}