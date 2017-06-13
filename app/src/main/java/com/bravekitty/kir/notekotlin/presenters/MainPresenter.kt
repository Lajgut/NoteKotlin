package com.bravekitty.kir.notekotlin.presenters

import com.bravekitty.kir.notekotlin.App
import com.bravekitty.kir.notekotlin.base_component.BasePresenter
import com.bravekitty.kir.notekotlin.database.RealmDatabase
import com.bravekitty.kir.notekotlin.view_states.MainView
import javax.inject.Inject


class MainPresenter : BasePresenter<MainView>() {

    @Inject
    internal  var realmDatabase: RealmDatabase? = null

    init {
        App.appComponent!!.inject(this)
    }
}