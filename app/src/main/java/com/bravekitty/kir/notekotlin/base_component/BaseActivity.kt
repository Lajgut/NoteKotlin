package com.bravekitty.kir.notekotlin.base_component

import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.bravekitty.kir.notekotlin.R

open class BaseActivity : MvpAppCompatActivity(), BaseView {

    override fun showProgressDialog() {
    }

    override fun hideProgressDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}