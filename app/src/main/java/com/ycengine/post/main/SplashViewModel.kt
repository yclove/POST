package com.ycengine.post.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ycengine.post.R
import com.ycengine.post.common.Constants
import com.ycengine.post.data.dto.AppVersionData
import com.ycengine.post.repository.remote.PostApiRepository
import com.ycengine.post.repository.remote.ValidResponse
import com.ycengine.post.widget.PostDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class SplashViewModel : ViewModel() {
    val appVersionData: MutableLiveData<AppVersionData.Response> = MutableLiveData()
    val exceptionCode: MutableLiveData<String> = MutableLiveData()
    val exceptionMessage: MutableLiveData<String> = MutableLiveData()

    init {
        PostApiRepository.service.getAppVersionData().enqueue(object : Callback<AppVersionData> {
            override fun onFailure(call: Call<AppVersionData>?, t: Throwable?) {
                Timber.e(t.toString())
            }

            override fun onResponse(call: Call<AppVersionData>?, response: Response<AppVersionData>) {
                response.body()?.let {
                    if (ValidResponse.validResponse(it.CODE)) {
                        appVersionData.value = it.RESPONSE
                    } else {
                        exceptionCode.value = it.CODE
                        exceptionMessage.value = it.MESSAGE
                    }
                }
            }
        })
    }
}