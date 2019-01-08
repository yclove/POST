package com.ycengine.post.repository.remote

import com.ycengine.post.data.dto.AppVersionModel
import com.ycengine.post.data.dto.BaseResponse
import com.ycengine.post.data.dto.PostData
import com.ycengine.post.data.dto.RegistUserModel
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
    fun getAppVersionData() : Call<BaseResponse<AppVersionModel>>

    // 사용자 정보 등록 요청
    @Headers(ApiCache.NO_CACHE)
    @POST("usr0201v1.post")
    fun registUser(@Body REQ_DATA: RequestBody) : Call<BaseResponse<RegistUserModel>>

    // POST 리스트 요청
    @Headers(ApiCache.NO_CACHE)
    @POST("pst0302v1.post")
    fun getPostData() : Call<BaseResponse<PostData>>
}