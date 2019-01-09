package com.ycengine.post.main

import android.arch.lifecycle.*
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Message
import android.provider.Settings
import android.view.View
import com.ycengine.post.R
import com.ycengine.post.common.Constants
import com.ycengine.post.common.PostException
import com.ycengine.post.common.base.BaseActivity
import com.ycengine.post.databinding.ActivityPostBinding
import com.ycengine.post.regist.RegistUserFragment
import com.ycengine.post.util.LocationUtil
import com.ycengine.post.util.SPUtil
import com.ycengine.post.util.handler.IOnHandlerMessage
import com.ycengine.post.util.handler.WeakRefHandler
import com.ycengine.post.widget.PostDialog
import timber.log.Timber

class PostActivity : BaseActivity(), IOnHandlerMessage, View.OnClickListener {

    private lateinit var binding: ActivityPostBinding
    private lateinit var viewModel: PostViewModel
    private var postDialog: PostDialog? = null
    private lateinit var locationUtil: LocationUtil

    private val mHandler by lazy {
        WeakRefHandler(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)

        initViewModel()
        initLayout()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders
            .of(this, object: ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return modelClass.getConstructor(LifecycleOwner::class.java).newInstance(this@PostActivity)
                }
            })
            .get(PostViewModel::class.java)

        viewModel.userId.observe(this, Observer {
            it?.let { userId ->
                if (userId.isEmpty()) {
                    val transaction = supportFragmentManager.beginTransaction()
                    //transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_in_left, R.anim.slide_out_left, R.anim.slide_out_right)
                    transaction.replace(
                        R.id.main_fragment,
                        RegistUserFragment.newInstance(),
                        RegistUserFragment::class.java.simpleName
                    ).addToBackStack(null)
                    transaction.commit()
                } else {
                    val fragment = supportFragmentManager.findFragmentById(R.id.main_fragment)
                    fragment?.let { child ->
                        if (child is RegistUserFragment) {
                            val transaction = supportFragmentManager.beginTransaction()
                            //transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_in_left, R.anim.slide_out_left, R.anim.slide_out_right)
                            transaction.remove(child)
                            transaction.commit()
                        }
                    }
                    viewModel.getPostUserData()
                }
            }
        })

        viewModel.userData.observe(this, Observer {
            it?.let {
                // 위치 서비스 설정
                if (SPUtil.getSharedPreference(this, Constants.SP_USER_LAT).isEmpty() || SPUtil.getSharedPreference(this, Constants.SP_USER_LNG).isEmpty()) {
                    locationUtil = LocationUtil(this, mHandler)
                    if (locationUtil.isLocationEnabled) {
                        locationUtil.run()
                    } else {
                        postDialog = PostDialog(this, Constants.DIALOG_TYPE_LOCATION_SERVICE, this).apply { show() }
                    }
                }
            }
        })

        viewModel.postException.observe(this, Observer {
            it?.let { e ->
                when (e.code) {
                    PostException.SW_UPDATE_NEEDED -> {
                        if (!isFinishing) {
                            postDialog = createGlobalDialog(Constants.DIALOG_EXCEPTION_UPDATE_NEED, true)?.apply { show() }
                        }
                    }
                    PostException.SW_UPDATE_SUPPORT -> {
                        if (!isFinishing) {
                            postDialog = createGlobalDialog(Constants.DIALOG_EXCEPTION_UPDATE_SUPPORT, true)?.apply { show() }
                        }
                    }
                    else -> {
                        postDialog = PostDialog(this, Constants.DIALOG_TYPE_INFO, this, e.message).apply { show() }
                    }
                }
            }
        })
    }

    private fun initLayout() {
        // 해외 접속 차단 레이아웃
        binding.countryCode = SPUtil.getSharedPreference(this, Constants.SP_COUNTRY_CODE)
    }

    override fun handleMessage(msg: Message?) {
        when (msg?.what) {
            Constants.DIALOG_EXCEPTION_NETWORK -> {
                if (!isFinishing) {
                    createGlobalDialog(Constants.DIALOG_EXCEPTION_NETWORK, true)?.show()
                }
            }
        }
    }

    override fun onClick(v: View?) {
        v?.let {
            when (it.id) {
                // 안내 타입의 확인 onClick
                R.id.btnInfoConfirm -> postDialog?.takeIf { dialog -> dialog.isShowing }?.apply { dismiss() }
                // 위치 서비스 설정 onClick
                R.id.btnLocationServiceSetting -> {
                    postDialog?.takeIf { dialog -> dialog.isShowing }?.apply { dismiss() }
                    intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                    startActivityForResult(intent, Constants.QUERY_LOCATION_SERVICE_SETTING)
                }
                else -> Timber.e("The request is else case. request : ${it.resources.getResourceEntryName(it.id)}")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            // 위치 서비스 설정 후 ActivityResult
            Constants.QUERY_LOCATION_SERVICE_SETTING -> {
                locationUtil.takeIf { it.isLocationEnabled }?.apply { run() }
            }
            else -> Timber.e("The request is else case. request code : $requestCode")
        }
    }
}