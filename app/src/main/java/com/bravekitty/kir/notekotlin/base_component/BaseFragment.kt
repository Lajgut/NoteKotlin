package com.bravekitty.kir.notekotlin.base_component

import android.app.ProgressDialog
import android.content.Context
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.bravekitty.kir.notekotlin.R
import org.jetbrains.anko.support.v4.toast


open class BaseFragment : MvpAppCompatFragment(), BaseView {

    protected var mContext: Context? = null
    private var mProgressDialog: ProgressDialog? = null
    //

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context
        //
    }

    override fun showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(mContext, R.style.MyThemeCustomAlertDialogStyle)
            mProgressDialog!!.setCancelable(false)
            mProgressDialog!!.setProgressStyle(android.R.style.Widget_ProgressBar_Small)
            mProgressDialog!!.show()
        }
        mProgressDialog!!.show()
    }

    override fun hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.hide()
        }
    }

    fun hideKeyboard() {
        val inputMethodManager = mContext!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
    }

    fun showKeyboard(et: EditText) {
        et.requestFocus()
        val keyboard = mContext!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboard.showSoftInput(et, 0)
    }

    override fun onDestroyView() {
        hideProgressDialog()
        super.onDestroyView()
    }

}