package com.bravekitty.kir.notekotlin.base_component

import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpView

interface BaseView : MvpView {

    fun showProgressDialog()

    fun hideProgressDialog()

}