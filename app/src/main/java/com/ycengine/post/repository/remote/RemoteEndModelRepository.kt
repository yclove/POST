package com.ycengine.post.repository.remote

import com.ycengine.post.data.model.*
import okhttp3.RequestBody
import retrofit2.Response
import java.io.IOException

class RemoteEndModelRepository {

    private var service = PostApiRepository.service

    fun getAppVersion(): AppVersionModel? {
        val response = service.getAppVersionData().execute()
        response.error()?.let { throw it }
        return response.body()!!.RESPONSE
    }

    fun registUser(body: RequestBody): RegistUserModel? {
        val response = service.registUser(body).execute()
        response.error()?.let { throw it }
        return response.body()!!.RESPONSE
    }

    fun getPostUserData(): PostUserModel? {
        val response = service.getPostUserData().execute()
        response.error()?.let { throw it }
        return response.body()!!.RESPONSE
    }

    fun getPost(): PostData? {
        val response = service.getPostData().execute()
        response.error()?.let { throw it }
        return response.body()!!.RESPONSE
    }

    private inline fun <T> Response<BaseModel<T>>.error(defaultMessage: String = "response fail"): IOException? = when {
        this.errorBody() != null -> IOException(this.errorBody()?.string())
        !this.isSuccessful || this.body() == null -> IOException(defaultMessage)
        !ValidResponse.validResponse(this.body()!!.CODE) -> IOException(this.body()!!.MESSAGE)
        else -> null
    }
}