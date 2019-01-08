package com.ycengine.post.regist

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ycengine.post.data.dto.RegistUserModel
import com.ycengine.post.repository.remote.RemoteEndModelRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody
import java.io.IOException

class RegistUserViewModel : ViewModel() {

    private val remoteRepository = RemoteEndModelRepository()

    val registUserModel: MutableLiveData<RegistUserModel> = MutableLiveData()
    val exceptionMessage: MutableLiveData<String> = MutableLiveData()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun registUser(body: RequestBody) {
        val disposable = Flowable.just(body)
            .subscribeOn(Schedulers.io())
            .map {
                remoteRepository.registUser(body)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                registUserModel.value = it
            }, {
                if (it is IOException) {
                    it.printStackTrace()
                }
                exceptionMessage.value = it.message
            })
        compositeDisposable.add(disposable)
    }
}