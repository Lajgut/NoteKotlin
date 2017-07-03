package com.bravekitty.kir.notekotlin.ui.acitvities


import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import com.bravekitty.kir.notekotlin.App
import com.bravekitty.kir.notekotlin.R
import com.bravekitty.kir.notekotlin.data.database.NoteRepository
import kotlinx.android.synthetic.main.activity_editor.*
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.android.synthetic.main.content_editor_toolbar.*
import javax.inject.Inject
import android.content.Intent
import android.widget.Toast
import android.speech.RecognizerIntent

class EditorActivity : AppCompatActivity(), View.OnClickListener {

    val VOICE_REC_REQUEST_CODE = 1001

    @Inject
    lateinit var noteRepository: NoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        App.appComponent.inject(this)

        /**
         * not need now
         */
        iv_text_from_photo!!.visibility = View.GONE
        iv_gallery.visibility = View.GONE

        iv_done.setOnClickListener(this)
        iv_share.setOnClickListener(this)
        iv_voice.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.iv_done -> {
                saveNote()
            }
            R.id.iv_share -> {
                sendIntentText()
            }

            R.id.iv_voice -> {
            }
        }
    }

    private fun saveNote() {
        val c = Calendar.getInstance()
        val df = SimpleDateFormat("dd-MMM-yyyy HH:mm")
        val formattedDate = df.format(c.time)

        noteRepository.addNote(
                getTextFromHeader(), getTextFromMainText(), formattedDate, null)

        finish()
    }


    private fun sendIntentText(){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, getTextFromHeader())
        intent.putExtra(Intent.EXTRA_TEXT, getTextFromMainText())

        startActivity(Intent.createChooser(intent, "Отправить текст"))
    }

    private fun getTextFromHeader() : String {
        if (!TextUtils.isEmpty(et_header!!.text)) {
            return et_header?.text.toString()
        }
        return ""
    }

    private fun getTextFromMainText() : String {
        if (!TextUtils.isEmpty(et_text!!.text)) {
            return et_text?.text.toString()
        }
        return ""
    }

    ////
    ///
    ///
    //набор методов для распознования голоса
    fun checkVoiceRecognition(): Boolean {
        val pm = packageManager
        val activities = pm.queryIntentActivities(Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0)
        return activities.size == 0
    }

    //метод вызывающий активность для распознования голоса
    fun speak(flag: Boolean) {
        if (flag) {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, javaClass.`package`.name)
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, et_text.getText().toString())
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH)
            startActivityForResult(intent, VOICE_REC_REQUEST_CODE)
        } else
            Toast.makeText(this, "aawfwaf", Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {

        //если все ок, то полученные варианты распознования храним в списке
        if (resultCode == Activity.RESULT_OK) {
            val textMatchList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)

            //если список не пуст, то берем 1й вариант и заносим его в edittext
            if (!textMatchList.isEmpty()) {

                //!!!!!!!!!!!!!!!!!!!!!
                /* if (textMatchList.get(0).contains("search")){
                    String searchQuery = textMatchList.get(0).replace("search", " ");
                    Intent search = new Intent(Intent.ACTION_WEB_SEARCH);
                    search.putExtra(SearchManager.QUERY, searchQuery);
                    startActivity(search);
                }
                else {*/
                //lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, textMatchList));

                val text = et_text.getText().toString()
                //если в едит текст что то уже есть, то после голосового ввода вставляет это плюс пробел, плюс голосовой текст
                if (text.isEmpty())
                    et_text.setText(textMatchList[0])
                else
                    et_text.setText(text + " " + textMatchList[0])
                // }
            }
        } else if (resultCode == RecognizerIntent.RESULT_AUDIO_ERROR) {
            //showErrorMsg(R.string.audio_error)
        } else if (resultCode == RecognizerIntent.RESULT_CLIENT_ERROR) {
            //showErrorMsg(R.string.client_error)
        } else if (resultCode == RecognizerIntent.RESULT_NETWORK_ERROR) {
            //showErrorMsg(R.string.network_error)
        } else if (resultCode == RecognizerIntent.RESULT_NO_MATCH) {
            //showErrorMsg(R.string.nomatch_error)
        } else if (resultCode == RecognizerIntent.RESULT_SERVER_ERROR) {
            //showErrorMsg(R.string.server_error)
        }
        super.onActivityResult(requestCode, resultCode, data)

    }

    fun showErrorMsg(msg: Int) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
