package com.ycengine.post.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ycengine.post.data.dto.AppVersionData
import com.ycengine.post.repository.remote.RemoteEndModelRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SplashViewModel : ViewModel() {

    private val repository = RemoteEndModelRepository()

    val appVersionData: MutableLiveData<AppVersionData> = MutableLiveData()
    val exceptionMessage: MutableLiveData<String> = MutableLiveData()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    init {
        val disposable = Flowable.just(Any())
            .subscribeOn(Schedulers.io())
            .map {
                repository.getAppVersion()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                appVersionData.value = it
            }, {
                exceptionMessage.value = it.message
            })
        compositeDisposable.add(disposable)
    }
}