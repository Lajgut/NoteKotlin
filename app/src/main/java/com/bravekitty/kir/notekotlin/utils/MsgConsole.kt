package com.bravekitty.kir.notekotlin.utils

import android.util.Log

/**
 * some devices have a lot of logs
 * very hard to explore what i want
 * this util helps me with what
 */
object MsgConsole {

    fun printlnDebug(msg: String) {

        Log.d("debug_tag", "---------------ОТЛАДОЧНОЕ СООБЩЕНИЕ---------------")
        Log.d("debug_tag", "---------------------$msg---------------------")
        Log.d("debug_tag", "---------------------------------------------------")
    }

    fun printlnErr(msg: String) {

        Log.d("error_message", "<---------------СООБЩЕНИЕ ОБ ОШИБКЕ--------------->")
        Log.d("error_message", "<---------------------$msg--------------------->")
        Log.d("error_message", "<--------------------------------------------------->")
    }

    fun printlnErr(e: Throwable) {

        Log.d("error_throwable", "<---------------СООБЩЕНИЕ ОБ ОШИБКЕ--------------->")
        Log.d("error_throwable", "<---------------------$e--------------------->")
        Log.d("error_throwable", "<--------------------------------------------------->")
    }
}
