package com.ycengine.post.repository.remote

import com.ycengine.post.data.model.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PostApiService {

    /**
     * local repository
     * ex) @POST("assets/app0101v1")
     */

    // 앱 버전 정보 요청
    @Headers(ApiCache.NO_CACHE)
    @POST("app0101v1.post")
    fun getAppVersionData() : Call<BaseModel<AppVersionModel>>

    // 사용자 정보 등록 요청
    @Headers(ApiCache.NO_CACHE)
    @POST("usr0201v1.post")
    fun registUser(@Body body: RequestBody) : Call<BaseModel<RegistUserModel>>

    // 사용자 정보 조회 요청
    @Headers(ApiCache.NO_CACHE)
    @POST("usr0202v1.post")
    fun getPostUserData() : Call<BaseModel<PostUserModel>>

    // 사용자 디바이스 정보 수정 요청
    @Headers(ApiCache.NO_CACHE)
    @POST("usr0222v1.post")
    fun updatePostUserData(@Body body: RequestBody) : Call<BaseModel<Any?>>

    // POST 리스트 요청
    @Headers(ApiCache.NO_CACHE)
    @POST("pst0302v1.post")
    fun getPostData() : Call<BaseModel<PostData>>
}