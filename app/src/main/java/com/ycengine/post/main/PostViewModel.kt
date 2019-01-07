package com.ycengine.post.main

import android.arch.lifecycle.ViewModel
import com.ycengine.post.data.dto.ColorModel
import com.ycengine.post.data.dto.HashPopKeywordModel
import com.ycengine.post.data.dto.MusPopKeywordModel
import com.ycengine.post.data.dto.PostPopKeywordModel
import com.ycengine.post.repository.database.DatabaseRepository
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class PostViewModel : ViewModel() {

    private val databaseRepository = DatabaseRepository()

    private var postColorData: List<ColorModel> = listOf()
    private var hashPopKeywordData: List<HashPopKeywordModel> = listOf()
    private var postPopKeywordData: List<PostPopKeywordModel> = listOf()
    private var musPopKeywordData: List<MusPopKeywordModel> = listOf()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    init {
        val disposable = Flowable.just(Any())
            .subscribeOn(Schedulers.io())
            .map {
                databaseRepository.getPostColor()
            }
            .doOnNext {
                postColorData = it
            }
            .map {
                databaseRepository.getHashPopKeyword()
            }
            .doOnNext {
                hashPopKeywordData = it
            }
            .map {
                databaseRepository.getPostPopKeyword()
            }
            .doOnNext {
                postPopKeywordData = it
            }
            .map {
                databaseRepository.getMusPopKeyword()
            }
            .doOnNext {
                musPopKeywordData = it
            }
            .subscribe ({
                Timber.e("postColorData size : ${postColorData.size}\nhashPopKeywordData size : ${hashPopKeywordData.size}\npostPopKeywordData size : ${postPopKeywordData.size}\nmusPopKeywordData size : ${musPopKeywordData.size}")
            }, {
                Timber.e("Error : ${it.message}")
            })
        compositeDisposable.add(disposable)
    }
}