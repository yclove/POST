package com.ycengine.post.repository.remote

import com.ycengine.post.data.dto.AppVersionData
import com.ycengine.post.data.dto.PostData
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.POST

interface PostApiService {

    // local repository : assets/app0101v1

    // 앱 버전 정보 요청
    @Headers(ApiCache.NO_CACHE)
    @POST("app0101v1.post")
    fun getAppVersionData() : Call<AppVersionData>

    // POST 리스트 요청
    @Headers(ApiCache.NO_CACHE)
    @POST("pst0302v1.post")
    fun getPostData() : Call<PostData>


//    @GET("rights/contents") // API
//    fun getRightContentsList(@Query("serviceType") serviceType: String?, @Query("recentType") recentType: Boolean = false, @Query("offset") offset: Int = 0, @Query("limit") limit: Int = 20): Call<RightContentsList>

}