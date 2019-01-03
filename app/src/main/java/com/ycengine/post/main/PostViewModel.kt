package com.ycengine.post.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ycengine.post.data.dto.PostData
import com.ycengine.post.repository.remote.PostApiRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class PostViewModel : ViewModel(), Callback<PostData> {
    private var postData: MutableLiveData<PostData> = MutableLiveData()

    init {
        PostApiRepository.service.getPostData().enqueue(this)
        postData.value = PostData()
    }

    override fun onFailure(call: Call<PostData>?, t: Throwable?) {
        Timber.e(t.toString())
    }

    override fun onResponse(call: Call<PostData>?, response: Response<PostData>) {
        postData.value = response.body()?.run { PostData() }
    }

    fun getEventModel(): LiveData<PostData> = postData
}