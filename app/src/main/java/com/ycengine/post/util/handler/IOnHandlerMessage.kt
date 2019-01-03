package com.naverlabs.around.handler

import android.os.Message

interface IOnHandlerMessage {

    fun handleMessage(msg: Message?)

}
