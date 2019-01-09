package com.ycengine.post.repository.remote

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


open class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    val exceptionMessage: MutableLiveData<String> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    init {
    }
}