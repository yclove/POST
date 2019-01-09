package com.ycengine.post.repository.remote

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ycengine.post.common.PostException
import com.ycengine.post.repository.database.DatabaseRepository
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

open class BaseViewModel : ViewModel() {

    val remoteRepository by lazy {
        RemoteEndModelRepository()
    }
    val databaseRepository by lazy {
        DatabaseRepository()
    }
    val compositeDisposable = CompositeDisposable()
    val postException: MutableLiveData<PostException> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
        Timber.e("Clear compositeDisposable size = ${compositeDisposable.size()}")
        compositeDisposable.clear()
    }
}