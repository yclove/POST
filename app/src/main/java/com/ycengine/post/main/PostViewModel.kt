package com.ycengine.post.main

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.ycengine.post.PostApplication
import com.ycengine.post.common.Constants
import com.ycengine.post.data.model.*
import com.ycengine.post.repository.database.DatabaseRepository
import com.ycengine.post.repository.remote.BaseViewModel
import com.ycengine.post.repository.remote.RemoteEndModelRepository
import com.ycengine.post.util.SPUtil
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class PostViewModel(lifecycleOwner: LifecycleOwner) : BaseViewModel() {

    private val remoteRepository = RemoteEndModelRepository()
    private val databaseRepository = DatabaseRepository()

    /**
     * YCNOTE : Transformations
     *
     * 변경된 LiveData 를 observer 에게 전달하기 전에 데이터를 가공하소 싶거나, 다른 LiveData 를 만들고 싶다면 Transformations 을 이용합니다.
     *
     * map - LiveData 를 return 하며, source 에 이벤트가 생길때마다 main thread 에서 function 이 수행된다.
     * switchMap - trigger LiveData 가 변경에 따라 이벤트를 발생 시키면 function 을 적용하여 결과를 새로만든 새로운 LiveData 에 set 한다. 또한 이때 새로운 LiveData 에 등록된 observer 들에게 재전송 된다.
     */
    val userId: MutableLiveData<String> = MutableLiveData()
    private val userData: MutableLiveData<PostUserModel> = MutableLiveData()

    private var postColorData: List<ColorModel> = listOf()
    private var hashPopKeywordData: List<HashPopKeywordModel> = listOf()
    private var postPopKeywordData: List<PostPopKeywordModel> = listOf()
    private var musPopKeywordData: List<MusPopKeywordModel> = listOf()

    init {
        GlobalScope.launch {
            postColorData = databaseRepository.getPostColor()
            hashPopKeywordData = databaseRepository.getHashPopKeyword()
            postPopKeywordData = databaseRepository.getPostPopKeyword()
            musPopKeywordData = databaseRepository.getMusPopKeyword()
        }

        userId.value = SPUtil.getSharedPreference(PostApplication.context, Constants.SP_USER_ID)

        userData.observe(lifecycleOwner, Observer {
            it?.let { userData ->
                SPUtil.setSharedPreference(PostApplication.context, Constants.SP_USER_GENDER, userData.gender)
                SPUtil.setSharedPreference(PostApplication.context, Constants.SP_USER_BIRTH_YEAR, userData.birthDate)
                SPUtil.setSharedPreference(PostApplication.context, Constants.SP_ACCOUNT_ID, userData.accountId)
                SPUtil.setSharedPreference(PostApplication.context, Constants.SP_ACCOUNT_AUTH_TYPE, userData.accountAuthType)
            }
        })
    }

    fun getPostUserData() {
        val disposable = Flowable.just(Any())
            .subscribeOn(Schedulers.io())
            .map {
                remoteRepository.getPostUserData()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                userData.value = it
            }, {
                if (it is IOException) {
                    it.printStackTrace()
                }
                exceptionMessage.value = it.message
            })
        compositeDisposable.add(disposable)
    }
}