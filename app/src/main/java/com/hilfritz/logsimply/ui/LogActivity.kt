package com.hilfritz.logsimply.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hilfritz.logsimply.MyApplication
import com.hilfritz.logsimply.R
import kotlinx.android.synthetic.main.activity_log.*

class LogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)
        val application = applicationContext as MyApplication
        var logSimply = application!!.logSimply!!
        logs.setText(logSimply.logString)
    }
}
