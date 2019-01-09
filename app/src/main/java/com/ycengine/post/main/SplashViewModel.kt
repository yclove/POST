package com.ycengine.post.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ycengine.post.data.model.*
import com.ycengine.post.repository.database.DatabaseRepository
import com.ycengine.post.repository.remote.RemoteEndModelRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.io.IOException

class SplashViewModel : ViewModel() {

    private val remoteRepository = RemoteEndModelRepository()
    private val databaseRepository = DatabaseRepository()

    val appVersionModel: MutableLiveData<AppVersionModel> = MutableLiveData()
    val exceptionMessage: MutableLiveData<String> = MutableLiveData()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    init {
    }

    fun getAppVersionData() {
        val disposable = Flowable.just(Any())
            .subscribeOn(Schedulers.io())
            .map {
                remoteRepository.getAppVersion()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                appVersionModel.value = it
            }, {
                if (it is IOException) {
                    it.printStackTrace()
                }
                exceptionMessage.value = it.message
            })
        compositeDisposable.add(disposable)
    }

    fun clearPostData() {
        try {
            databaseRepository.clearPostData()
            Timber.e("Post data 초기화")
        } catch (e: Exception) {
            Timber.e("Post data 초기화에 실패하였습니다. (${e.message})")
        }
    }

    fun insertPostColorData(colors: List<ColorModel>) {
        databaseRepository.insertColors(colors)
    }

    fun insertHashPopKeyword(keywords: List<HashPopKeywordModel>) {
        databaseRepository.insertHashPopKeyword(keywords)
    }

    fun insertPostPopKeyword(keywords: List<PostPopKeywordModel>) {
        databaseRepository.insertPostPopKeyword(keywords)
    }

    fun insertMusPopKeyword(keywords: List<MusPopKeywordModel>) {
        databaseRepository.insertMusPopKeyword(keywords)
    }
}