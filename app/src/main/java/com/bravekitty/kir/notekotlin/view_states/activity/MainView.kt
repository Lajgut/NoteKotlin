package com.bravekitty.kir.notekotlin.view_states.activity

import android.support.v4.app.Fragment
import com.bravekitty.kir.notekotlin.base_component.BaseView
import com.bravekitty.kir.notekotlin.models.NoteModel
import io.realm.RealmResults


interface MainView : BaseView {
    fun initFragment(fragment: Fragment, tag: String)
}