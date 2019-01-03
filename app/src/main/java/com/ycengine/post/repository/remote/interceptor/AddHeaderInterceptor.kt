package com.ycengine.post.repository.remote.interceptor

import com.ycengine.post.common.Constants
import com.ycengine.post.util.KeyUtil
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.net.URLDecoder

class AddHeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val timeStamp: Long = System.currentTimeMillis()
        val tokenKey = KeyUtil.getTokenKey(Constants.POST_SECRET_KEY, Constants.POST_ACCESS_KEY, timeStamp.toString())

        val builder = original.newBuilder()
        builder.addHeader("Content-Type", "application/x-www-form-urlencoded")
        builder.addHeader("device-os-version", android.os.Build.VERSION.RELEASE)
        builder.addHeader("device-model", android.os.Build.MODEL)
        builder.addHeader("device-type", Constants.HEADER_DEVICE_TYPE)
        builder.addHeader("post-app-version", Constants.APP_VERSION_CODE.toString())
        builder.addHeader("post-app-user-id", "yclove")//SPUtil.getSharedPreference(mContext, Constants.SP_USER_ID)
        builder.addHeader("post-access-token", tokenKey)
        builder.addHeader("post-access-key", Constants.POST_ACCESS_KEY)
        builder.addHeader("post-timestamp", timeStamp.toString())
        builder.addHeader("post-app-user-log", Constants.API_UV_LOGGING)

        builder.method(original.method(), original.body())
        val request = builder.build()

        val response = chain.proceed(request)

        return response.newBuilder()
            .body(
                ResponseBody.create(
                    response.body()?.contentType(),
                    URLDecoder.decode(response.body()?.string(), "utf-8")
                )
            )
            .build()
    }
}