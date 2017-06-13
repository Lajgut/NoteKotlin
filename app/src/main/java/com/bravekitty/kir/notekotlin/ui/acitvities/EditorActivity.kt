package com.bravekitty.kir.notekotlin.ui.acitvities


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import com.bravekitty.kir.notekotlin.App
import com.bravekitty.kir.notekotlin.R
import com.bravekitty.kir.notekotlin.database.RealmDatabase
import kotlinx.android.synthetic.main.activity_editor.*
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.android.synthetic.main.content_editor_toolbar.*
import javax.inject.Inject


class EditorActivity : AppCompatActivity(), View.OnClickListener {

    @Inject
    lateinit var realmDatabase: RealmDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        App.appComponent.inject(this)

        /**
         * not need now
         */
        iv_text_from_photo!!.visibility = View.GONE
        iv_gallery!!.visibility = View.GONE
        iv_done!!.setOnClickListener(this)
        iv_share!!.setOnClickListener(this)
        iv_voice!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.iv_done -> {
                var header = ""
                var text = ""
                if (!TextUtils.isEmpty(et_header!!.text)) {
                    header = et_header!!.text.toString()
                }
                if (!TextUtils.isEmpty(et_text!!.text)) {
                    text = et_text!!.text.toString()
                }

                val c = Calendar.getInstance()
                val df = SimpleDateFormat("dd-MMM-yyyy HH:mm")
                val formattedDate = df.format(c.time)

                realmDatabase.addNote(header, text, formattedDate, null)
                finish()
            }
            R.id.iv_share -> {
            }
            R.id.iv_voice -> {
            }
        }
    }
}
