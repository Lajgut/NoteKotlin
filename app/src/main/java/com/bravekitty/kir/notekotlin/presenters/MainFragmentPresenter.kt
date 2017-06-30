package com.bravekitty.kir.notekotlin.presenters

import com.arellomobile.mvp.InjectViewState
import com.bravekitty.kir.notekotlin.App
import com.bravekitty.kir.notekotlin.base_component.BasePresenter
import com.bravekitty.kir.notekotlin.data.database.NoteRepository
import com.bravekitty.kir.notekotlin.view_states.fragment.MainFragmentView
import javax.inject.Inject

@InjectViewState
class MainFragmentPresenter : BasePresenter<MainFragmentView>() {

    @Inject
    lateinit  var noteRepository: NoteRepository

    init {
        App.appComponent.inject(this)
    }

    override fun attachView(view: MainFragmentView?) {
        super.attachView(view)
        getAllNotesFromDatabase()
    }

    fun getAllNotesFromDatabase() {
        viewState.initNotesData(noteRepository.findAll())
    }

}
