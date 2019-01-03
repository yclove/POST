package com.ycengine.post.repository.remote

import com.ycengine.post.BuildConfig
import com.ycengine.post.PostApplication
import com.ycengine.post.repository.remote.interceptor.AddHeaderInterceptor
import com.ycengine.post.repository.remote.interceptor.AssetFileInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

object PostApiRepository {

    private val client: OkHttpClient = OkHttpClient.Builder()
        // 세션 유지 방법
//        .cookieJar(WebCookieJar())
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .addInterceptor(AssetFileInterceptor(PostApplication.context.assets))
        .addInterceptor(AddHeaderInterceptor())
        .build()

    val service: PostApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
            .create(PostApiService::class.java)
    }
}