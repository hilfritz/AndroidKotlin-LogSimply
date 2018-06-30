package com.hilfritz.logsimply

import android.app.Application
import android.widget.Toast
import com.hilfritz.logsimply.core.LogSimply
import com.hilfritz.logsimply.core.LogSimplySaveCallbacks
import com.hilfritz.logsimply.core.LogSimplyInterface
import com.hilfritz.logsimply.core.filewriter.LogSimplyEasyFileWriter

/**
 *
 * @author Hilfritz Camallere on 21/6/18
 *
 */
class MyApplication : Application(), LogSimplySaveCallbacks {
    val TAG = "MyApplication"
    lateinit var logSimply: LogSimplyInterface
    lateinit var fileWriter: LogSimplyEasyFileWriter

    override fun onCreate() {
        super.onCreate()
        fileWriter = LogSimplyEasyFileWriter()
        logSimply = LogSimply()
        logSimply.saveCallbacks = this
    }

    override fun saveLogs(logStr: String) {
        //Log.d(TAG, logStr)
        Toast.makeText(this, logStr, Toast.LENGTH_LONG).show()
        fileWriter.writeStringToFile(logStr, fileWriter.getFile())
    }

}