package com.ycengine.post

import android.content.Context
import android.support.multidex.MultiDexApplication
import timber.log.Timber

class PostApplication : MultiDexApplication() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        context = this
        configLogger()
    }

    private fun configLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}