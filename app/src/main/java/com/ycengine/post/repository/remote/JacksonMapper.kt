package com.ycengine.post.repository.remote

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import timber.log.Timber
import java.io.StringWriter

val objectMapper: ObjectMapper = ObjectMapper().apply {
    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
    registerModule(KotlinModule())
}

/**
 * Object 를 json 스트링으로 변환.
 */
fun Any.toJson(): String {
    return StringWriter().apply {
        try {
            objectMapper.writeValue(this, this@toJson)
        } catch (e: Exception) {
            Timber.w(e, "Failed create json string.")
        }
    }.toString()
}

/**
 * Json String 을 Object 로 변환 할 때 사용. <br/>
 * @return 실패하면 null.
 */
fun <T> String.toObject(targetClass: Class<T>): T? {
    return try {
        objectMapper.readValue(this, targetClass)
    } catch (e: Exception) {
        null
    }
}