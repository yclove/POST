package com.ycengine.post.main

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.google.gson.Gson
import com.ycengine.post.PostApplication
import com.ycengine.post.common.Constants
import com.ycengine.post.common.PostException
import com.ycengine.post.data.model.*
import com.ycengine.post.repository.remote.BaseViewModel
import com.ycengine.post.util.SPUtil
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject

class PostViewModel(lifecycleOwner: LifecycleOwner) : BaseViewModel() {

    /**
     * YCNOTE : Transformations
     *
     * 변경된 LiveData 를 observer 에게 전달하기 전에 데이터를 가공하소 싶거나, 다른 LiveData 를 만들고 싶다면 Transformations 을 이용합니다.
     *
     * map - LiveData 를 return 하며, source 에 이벤트가 생길때마다 main thread 에서 function 이 수행된다.
     * switchMap - trigger LiveData 가 변경에 따라 이벤트를 발생 시키면 function 을 적용하여 결과를 새로만든 새로운 LiveData 에 set 한다. 또한 이때 새로운 LiveData 에 등록된 observer 들에게 재전송 된다.
     */
    val userId: MutableLiveData<String> = MutableLiveData()
    val userData: MutableLiveData<PostUserModel> = MutableLiveData()
    private val postData: MutableLiveData<PostModel> = MutableLiveData()

    private val postColorData: LiveData<List<ColorModel>> = databaseRepository.getPostColor()
    private val hashPopKeywordData: LiveData<List<HashPopKeywordModel>> = databaseRepository.getHashPopKeyword()
    private val postPopKeywordData: LiveData<List<PostPopKeywordModel>> = databaseRepository.getPostPopKeyword()
    private val musPopKeywordData: LiveData<List<MusPopKeywordModel>> = databaseRepository.getMusPopKeyword()

    init {
        userId.value = SPUtil.getSharedPreference(PostApplication.context, Constants.SP_USER_ID)

        userData.observe(lifecycleOwner, Observer {
            it?.let { userData ->
                SPUtil.setSharedPreference(PostApplication.context, Constants.SP_USER_GENDER, userData.gender)
                SPUtil.setSharedPreference(PostApplication.context, Constants.SP_USER_BIRTH_YEAR, userData.birthDate)
                SPUtil.setSharedPreference(PostApplication.context, Constants.SP_ACCOUNT_ID, userData.accountId)
                SPUtil.setSharedPreference(PostApplication.context, Constants.SP_ACCOUNT_AUTH_TYPE, userData.accountAuthType)

                // 등록 된 PUSH ID 와 조회 된 PUSH ID 가 다를 경우 사용자 디바이스 정보 수정을 요청한다.
                var isPushExist = false
                for (item in userData.pushDataList) {
                    if (SPUtil.getSharedPreference(PostApplication.context, Constants.SP_PUSH_ID).equals(item.pushId, ignoreCase = false)) {
                        isPushExist = true
                        break
                    }
                }

                if (!isPushExist) {
                    val jsonObject = JSONObject()
                    jsonObject.put("PUSH_ID", SPUtil.getSharedPreference(PostApplication.context, Constants.SP_PUSH_ID))
                    val body = RequestBody.create(MediaType.parse(Constants.HEADER_CONTENT_TYPE_FORM), "REQ_DATA=$jsonObject")
                    updatePostUserData(body)
                }

                val postModelReq = PostModelReq()
                postModelReq.LOCA_LAT = SPUtil.getSharedPreference(PostApplication.context, Constants.SP_USER_LAT)
                postModelReq.LOCA_LNG = SPUtil.getSharedPreference(PostApplication.context, Constants.SP_USER_LNG)
                val content = "REQ_DATA=${Gson().toJson(postModelReq)}"
                val body = RequestBody.create(MediaType.parse(Constants.HEADER_CONTENT_TYPE_FORM), content)
                getPostData(body)
            }
        })
    }

    fun getPostUserData() {
        Flowable.just(Any())
            .subscribeOn(Schedulers.io())
            .map {
                remoteRepository.getPostUserData()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                userData.value = it
            }, {
                if (it is PostException) {
                    postException.value = it
                }
                it.printStackTrace()
            }).apply {
                compositeDisposable.add(this)
            }
    }

    private fun updatePostUserData(body: RequestBody) {
        Flowable.just(Any())
            .subscribeOn(Schedulers.io())
            .map {
                remoteRepository.updatePostUserData(body)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, {
                if (it is PostException) {
                    postException.value = it
                }
                it.printStackTrace()
            }).apply {
                compositeDisposable.add(this)
            }
    }

    private fun getPostData(body: RequestBody) {
        Flowable.just(Any())
            .subscribeOn(Schedulers.io())
            .map {
                remoteRepository.getPostData(body)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                postData.value = it
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