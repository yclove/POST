package com.ycengine.post.repository.remote

import com.ycengine.post.common.PostException
import com.ycengine.post.data.model.*
import okhttp3.RequestBody
import retrofit2.Response

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

    fun updatePostUserData(body: RequestBody) {
        val response = service.updatePostUserData(body).execute()
        response.error()?.let { throw it }
    }

    fun getPost(): PostData? {
        val response = service.getPostData().execute()
        response.error()?.let { throw it }
        return response.body()!!.RESPONSE
    }

    private inline fun <T> Response<BaseModel<T>>.error(): PostException? = when {
        this.errorBody() != null -> PostException(PostException.ERROR_BODY, this.errorBody()?.string() ?: "")
        !this.isSuccessful -> PostException(PostException.IS_NOT_SUCCESSFUL, "IS_NOT_SUCCESSFUL")
        this.body() == null -> PostException(PostException.NULL_BODY, "NULL_BODY")
        !PostException.SUCCESS.equals(this.body()!!.CODE, ignoreCase = false) -> PostException(this.body()!!.CODE, this.body()!!.MESSAGE)
        else -> null
    }
}