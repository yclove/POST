package com.ycengine.post.data.dto

data class BaseResponse<T>(
    val MESSAGE: String = "",
    val CODE: String = "",
    val RESPONSE: T?
)