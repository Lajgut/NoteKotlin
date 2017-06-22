package com.bravekitty.kir.notekotlin.ui.acitvities

import android.content.Context
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bravekitty.kir.notekotlin.R
import com.bravekitty.kir.notekotlin.base_component.BaseActivity
import com.bravekitty.kir.notekotlin.presenters.MainPresenter
import com.bravekitty.kir.notekotlin.ui.fragments.MainFragment
import com.bravekitty.kir.notekotlin.utils.instanceOf
import com.bravekitty.kir.notekotlin.view_states.activity.MainView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener,
        MainView {

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this@MainActivity

        initUI()
    }

    fun initUI() {
        setSupportActionBar(toolbar)

        fab.setOnClickListener { startActivity<EditorActivity>() }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        initFragment(instanceOf<MainFragment>(), MainFragment.TAG)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun initFragment(fragment: Fragment, tag: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.main_container, fragment)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.commit()
    }


    override fun onDestroy() {
        super.onDestroy()
        /**
         * free resources when activity destroyed
         */
        mainPresenter.closeRealm()
    }
}
