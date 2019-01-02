package com.ycengine.post.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val SPLASH_DELAY: Long = 3000
    }

    private var mDelayHandler: Handler? = null

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(applicationContext, PostActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mDelayHandler = Handler()
        mDelayHandler?.postDelayed(mRunnable, SPLASH_DELAY)
    }

    public override fun onDestroy() {
        mDelayHandler?.removeCallbacks(mRunnable)
        super.onDestroy()
    }
}