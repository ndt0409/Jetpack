package com.ndt.jetpack.util

import android.util.Log
import com.ndt.jetpack.BuildConfig

object Logger {
    fun logD(tag: String, message: String) {
        if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.DEBUG)) {
            Log.d(tag, message)
        }
    }
    fun logE(tag: String, message: String) {
        if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.ERROR)) {
            Log.d(tag, message)
        }
    }
}