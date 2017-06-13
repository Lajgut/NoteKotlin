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

    override fun initFragment(fragment: Fragment, tag: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.main_container, fragment)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.commit()
    }

}