package com.ycengine.post.common.base

import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

abstract class BaseActivity : RxBaseActivity() {

    private var imageRequestManager: RequestManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageRequestManager = Glide.with(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        imageRequestManager?.onDestroy()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Glide.get(this).trimMemory(level)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Glide.get(this).clearMemory()
    }
}