package com.ycengine.post.regist

import android.arch.lifecycle.MutableLiveData
import com.ycengine.post.common.PostException
import com.ycengine.post.data.model.RegistUserModel
import com.ycengine.post.repository.remote.BaseViewModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody

class RegistUserViewModel : BaseViewModel() {

    val registUserModel: MutableLiveData<RegistUserModel> = MutableLiveData()

    fun registUser(body: RequestBody) {
        Flowable.just(body)
            .subscribeOn(Schedulers.io())
            .map {
                remoteRepository.registUser(body)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                registUserModel.value = it
            }, {
                if (it is PostException) {
                    postException.value = it
                }
                it.printStackTrace()
            }).apply {
                compositeDisposable.add(this)
            }
    }
}