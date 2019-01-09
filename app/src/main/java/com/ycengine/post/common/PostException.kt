package com.ycengine.post.common

class PostException(val code: String, message: String) : Exception(message) {
    companion object {
        const val SUCCESS = "0000"
        const val ERROR_BODY = "9001"
        const val IS_NOT_SUCCESSFUL = "9002"
        const val NULL_BODY = "9003"
        const val SW_UPDATE_NEEDED = "0100"
        const val SW_UPDATE_SUPPORT = "0101"
    }
}