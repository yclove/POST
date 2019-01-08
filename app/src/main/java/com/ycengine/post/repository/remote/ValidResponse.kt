package com.ycengine.post.repository.remote

class ValidResponse {

    companion object {
        private const val SUCCESS_CODE = "0000"
        private const val SW_UPDATE_NEEDED = "0100"
        private const val SW_UPDATE_SUPPORT = "0101"

        fun validResponse(code: String): Boolean {
            /*when (code) {
                SW_UPDATE_NEEDED, SW_UPDATE_SUPPORT -> {
                    return false
                }
            }
            return true*/
            return code.equals(SUCCESS_CODE, ignoreCase = false)
        }
    }
}