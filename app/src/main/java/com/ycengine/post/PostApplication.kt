package com.ycengine.post

import android.support.multidex.MultiDexApplication
import timber.log.Timber

class PostApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        configLogger()
    }

    private fun configLogger() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}