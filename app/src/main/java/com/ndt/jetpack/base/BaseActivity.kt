package com.ndt.jetpack.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.ndt.jetpack.monitor.ActivityMonitor

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val activityMonitor = ActivityMonitor(lifecycle)
        lifecycle.addObserver(activityMonitor)
    }
}