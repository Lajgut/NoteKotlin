package com.bravekitty.kir.notekotlin.base_component

import android.app.ProgressDialog
import android.content.Context
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast

import com.bravekitty.kir.notekotlin.R
import com.bravekitty.kir.notekotlin.ui.FragmentTransitionListener

abstract class BaseFragment : Fragment() {

    protected var mContext: Context? = null
    private var mProgressDialog: ProgressDialog? = null
    //

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context
        //
    }

    protected fun showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(mContext, R.style.MyThemeCustomAlertDialogStyle)
            mProgressDialog!!.setCancelable(false)
            mProgressDialog!!.setProgressStyle(android.R.style.Widget_ProgressBar_Small)
            mProgressDialog!!.show()
        }
        mProgressDialog!!.show()
    }

    protected fun hideProgressDialog() {
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


    protected fun showToast(message: Int) {
        Toast.makeText(mContext, getString(message), Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        hideProgressDialog()
        super.onDestroyView()
    }

}
