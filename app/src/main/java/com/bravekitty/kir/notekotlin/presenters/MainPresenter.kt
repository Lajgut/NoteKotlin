package com.bravekitty.kir.notekotlin.presenters

import com.bravekitty.kir.notekotlin.App
import com.bravekitty.kir.notekotlin.base_component.BasePresenter
import com.bravekitty.kir.notekotlin.data.database.RealmDatabase
import com.bravekitty.kir.notekotlin.view_states.activity.MainView
import javax.inject.Inject


class MainPresenter : BasePresenter<MainView>() {

    @Inject
    lateinit  var realmDatabase: RealmDatabase

    init {
        App.appComponent.inject(this)
    }

    fun closeRealm() {
        realmDatabase.closeOnDestroy()
    }


}