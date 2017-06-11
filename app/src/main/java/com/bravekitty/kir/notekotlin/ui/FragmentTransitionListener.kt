package com.bravekitty.kir.notekotlin.ui

import android.support.v4.app.Fragment

interface FragmentTransitionListener {

    fun initFragment(fragment: Fragment, tag: String)
}