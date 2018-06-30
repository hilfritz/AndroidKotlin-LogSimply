package com.hilfritz.logsimply


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.hilfritz.logsimply.core.LogSimplyInterface
import com.hilfritz.logsimply.ui.LogActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    var correctUsername ="johndoe@gmail.com"
    var correctPassword = "john123"
    private lateinit var logSimply:LogSimplyInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val application = applicationContext as MyApplication
        logSimply = application!!.logSimply!!
        lifecycle.addObserver(logSimply)

        logDisplay.movementMethod = ScrollingMovementMethod()

        login.setOnClickListener {
            logSimply.logStart()
            val userName = username.text.toString()
            val password = password.text.toString()
            handleUsernamePassword(userName, password)
            hideKeyboard()
        }


    }

    fun handleUsernamePassword(userNameStr:String, passwordStr:String){

        logSimply.log("SEQ #1: [CHECK-USERNAME-LENGTH] DATA: username:"+userNameStr)
        if (userNameStr.isEmpty()){
            logSimply.log("SEQ #1: [CHECK-USERNAME-LENGTH] FAIL")
            showToast("Username required.")
            return
        }
        logSimply.log("SEQ #1: [CHECK-PASSWORD-LENGTH] DATA: passwordStr:"+passwordStr)
        if (passwordStr.isEmpty()){
            logSimply.log("SEQ #1: [CHECK-PASSWORD-LENGTH] FAIL")
            showToast("Password required.")
            return
        }

        if (userNameStr.equals(correctUsername)){
            logSimply.log("SEQ #2: [CHECK-USERNAME-VALIDITY] OK")
        }else{
            logSimply.log("SEQ #2: [CHECK-USERNAME-VALIDITY] FAIL")
            showToast("Username incorrect.")
            return
        }


        if (passwordStr.equals(correctPassword)){
            logSimply.log("SEQ #2: [CHECK-PASSWORD-VALIDITY] OK")
        }else{
            logSimply.log("SEQ #2: [CHECK-PASSWORD-VALIDITY] FAIL")
            showToast("Password incorrect.")
            return
        }

        if (userNameStr.equals(correctUsername) && passwordStr.equals(correctPassword)){
            showToast("Login Successful!")
            val intent = Intent(this, LogActivity::class.java)
            startActivity(intent)
        }else{
            showToast("Something went wrong. Please try again...")
        }
        username.setText("")
        password.setText("")
    }

    fun showToast(str:String){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }


    fun hideKeyboard(){
        // Check if no view has focus:
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}
