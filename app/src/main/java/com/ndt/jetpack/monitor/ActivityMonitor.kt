package com.ndt.jetpack.monitor

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.ndt.jetpack.util.Logger

class ActivityMonitor(private val lifecycle: Lifecycle) :LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun logOnCreate(){
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.DESTROYED)){

        }
        Logger.logD("tund", "Activity Created")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun logOnStop(){
        Logger.logD("tund", "Activity Stopped")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun logStart(){
        Logger.logD("tund", "Activity Started")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun logPause(){
        Logger.logD("tund", "Activity Paused")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun logResume(){
        Logger.logD("tund", "Activity Resumed")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun logDestroy(){
        Logger.logD("tund", "Activity Destroyed")
    }
}