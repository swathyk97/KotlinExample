package com.example.kotlinexample

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {
    private val mDelay = 3000
    private var handler: Handler? = null
    private var runnable: Runnable? = null
    private var mIntent: Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag","swathy3")
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar!!.hide()
        setContentView(R.layout.activity_main)
        this.mIntent = Intent(this, MainActivity::class.java)
        handler = Handler()
        runnable = Runnable {

            mIntent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            mIntent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            mIntent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(mIntent)
            finish()
        }
        handler!!.postDelayed(runnable, mDelay.toLong())
    }

    }
