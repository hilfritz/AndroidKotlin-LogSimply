package com.hilfritz.logsimply.core

import android.arch.lifecycle.LifecycleObserver

/**
 *
 * @author Hilfritz Camallere on 20/6/18
 *
 */
interface LogSimplyInterface: LifecycleObserver {
    var logId:String
    var logString:String
    var saveCallbacks: LogSimplySaveCallbacks

    fun logStart()
    fun log(logStr:String)
    fun logEnd()

}