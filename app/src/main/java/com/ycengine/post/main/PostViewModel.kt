package com.ycengine.post.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ycengine.post.PostApplication
import com.ycengine.post.common.Constants
import com.ycengine.post.data.dto.ColorModel
import com.ycengine.post.data.dto.HashPopKeywordModel
import com.ycengine.post.data.dto.MusPopKeywordModel
import com.ycengine.post.data.dto.PostPopKeywordModel
import com.ycengine.post.repository.database.DatabaseRepository
import com.ycengine.post.util.SPUtil
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    private val databaseRepository = DatabaseRepository()

    val userId: MutableLiveData<String> = MutableLiveData()

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
        userId.value = SPUtil.getSharedPreference(PostApplication.context, Constants.SP_USER_ID)

        GlobalScope.launch {
            postColorData = databaseRepository.getPostColor()
            hashPopKeywordData = databaseRepository.getHashPopKeyword()
            postPopKeywordData = databaseRepository.getPostPopKeyword()
            musPopKeywordData = databaseRepository.getMusPopKeyword()
        }
    }
}