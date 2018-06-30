package com.hilfritz.logsimply.core

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log


/**
 *
 * @author Hilfritz Camallere on 20/6/18
 * see https://stackoverflow.com/questions/35481924/write-a-string-to-a-file/35481977
 */
class LogSimply : LogSimplyInterface{
    val TAG = "LogSimply"
    override var logId: String = ""
    override var logString: String = ""
    override lateinit var saveCallbacks: LogSimplySaveCallbacks


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        saveCallbacks?.saveLogs(logString)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
    }

    override fun logStart() {
        logId = "[id:"+System.currentTimeMillis().toString()+"]"
    }

    override fun log(logStr: String) {
        Log.d(TAG, logStr)
        logString+="\n"+logId+" "+logStr
    }

    override fun logEnd() {
        logStart()
    }


}