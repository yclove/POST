package com.ycengine.post.repository.remote

import com.ycengine.post.data.dto.AppVersionData
import com.ycengine.post.data.dto.BaseResponse
import com.ycengine.post.data.dto.PostData
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
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
    fun getAppVersionData() : Call<BaseResponse<AppVersionData>>

    // POST 리스트 요청
    @Headers(ApiCache.NO_CACHE)
    @POST("pst0302v1.post")
    fun getPostData() : Call<BaseResponse<PostData>>
}