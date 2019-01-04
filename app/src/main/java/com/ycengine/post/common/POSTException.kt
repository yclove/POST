package com.ycengine.post.common

class POSTException(code: String, message: String) : Exception(message) {

    var code: String
        internal set

    init {
        this.code = code
    }

    /*override fun getMessage(): String {
        if (code === SW_UPDATE_NEEDED) {
            return "" + SW_UPDATE_NEEDED
        }
        return if (message.equals(SW_UPDATE_NEEDED, ignoreCase = true)) {
            this.message + "."
        } else this.message
    }*/
}