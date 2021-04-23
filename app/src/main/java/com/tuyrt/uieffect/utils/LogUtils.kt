package com.tuyrt.uieffect.utils

import android.util.Log

object LogUtils {

    private const val TAG = "aaaa"

    fun e(msg: String) {
        Log.e(TAG, msg)
    }

    fun e(tag: String, msg: String) {
        Log.e(tag, msg)
    }

    fun d(msg: String) {
        Log.d(TAG, msg)
    }

    fun d(tag: String, msg: String) {
        Log.d(tag, msg)
    }

}