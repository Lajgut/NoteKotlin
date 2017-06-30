package com.bravekitty.kir.notekotlin.presenters

import com.bravekitty.kir.notekotlin.App
import com.bravekitty.kir.notekotlin.base_component.BasePresenter
import com.bravekitty.kir.notekotlin.data.database.NoteRepository
import com.bravekitty.kir.notekotlin.view_states.activity.MainView
import javax.inject.Inject


class MainPresenter : BasePresenter<MainView>() {

    @Inject
    lateinit  var noteRepository: NoteRepository

    init {
        App.appComponent.inject(this)
    }

}