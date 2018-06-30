package com.hilfritz.logsimply.core

/**
 *
 * @author Hilfritz Camallere on 21/6/18
 *
 */
interface LogSimplySaveCallbacks {
    //this will get called whenever the Application/Activity class's onStop is called
    //call this in onStop()
    fun saveLogs(logStr:String)
}