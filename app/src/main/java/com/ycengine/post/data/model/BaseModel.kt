package com.ycengine.post.data.model

data class BaseModel<T>(
    val MESSAGE: String = "",
    val CODE: String = "",
    val RESPONSE: T?
)