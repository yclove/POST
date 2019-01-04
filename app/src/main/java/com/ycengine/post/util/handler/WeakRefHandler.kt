package com.ycengine.post.util.handler

import android.os.Handler
import android.os.Message
import java.lang.ref.WeakReference

class WeakRefHandler(activity: IOnHandlerMessage) : Handler() {
    private var mHandlerActivity: WeakReference<IOnHandlerMessage> = WeakReference(activity)

    override fun handleMessage(msg: Message?) {
        super.handleMessage(msg)
        mHandlerActivity.get()?.handleMessage(msg)
    }
}