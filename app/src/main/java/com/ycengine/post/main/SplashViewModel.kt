package com.ycengine.post.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ycengine.post.data.dto.AppVersionData
import com.ycengine.post.repository.remote.PostApiRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class SplashViewModel : ViewModel() {
    val appVersionData: MutableLiveData<AppVersionData> = MutableLiveData()

    init {
        PostApiRepository.service.getAppVersionData().enqueue(object : Callback<AppVersionData> {
            override fun onFailure(call: Call<AppVersionData>?, t: Throwable?) {
                Timber.e(t.toString())
            }

            override fun onResponse(call: Call<AppVersionData>?, response: Response<AppVersionData>) {
                appVersionData.value = response.body()
            }
        })
    }
}