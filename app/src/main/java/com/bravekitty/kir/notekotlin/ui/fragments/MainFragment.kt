package com.bravekitty.kir.notekotlin.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.arellomobile.mvp.presenter.InjectPresenter
import com.bravekitty.kir.notekotlin.R
import com.bravekitty.kir.notekotlin.adapters.NoteAdapter
import com.bravekitty.kir.notekotlin.base_component.BaseFragment
import com.bravekitty.kir.notekotlin.models.NoteModel
import com.bravekitty.kir.notekotlin.presenters.MainFragmentPresenter
import com.bravekitty.kir.notekotlin.view_states.fragment.MainFragmentView
import io.realm.RealmResults
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(), MainFragmentView {

    @InjectPresenter
    lateinit var mMainFragmentPresenter: MainFragmentPresenter

    //todo Наверняка в котлине или анко есть способ поинтереснее это сделать
    companion object {
        val TAG = "MainFragment"
        val KEY = "MainFragmentkey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initNotesData(notesList: RealmResults<NoteModel>) {
        val noteAdapter = NoteAdapter(notesList, null, false)
        recycler_view.layoutManager = LinearLayoutManager(context, VERTICAL, false)
        recycler_view.adapter = noteAdapter
    }
}