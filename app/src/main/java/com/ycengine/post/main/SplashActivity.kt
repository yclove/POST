package com.ycengine.post.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.ycengine.post.BuildConfig
import com.ycengine.post.R
import com.ycengine.post.common.Constants
import com.ycengine.post.common.base.BaseActivity
import com.ycengine.post.databinding.ActivitySplashBinding
import com.ycengine.post.widget.PostDialog
import timber.log.Timber

class SplashActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var viewModel: SplashViewModel
    private var mPostDialog: PostDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        viewModel = ViewModelProviders
            .of(this)
            .get(SplashViewModel::class.java)

        viewModel.appVersionData.observe(this, Observer {
            it?.let { appVersionData ->
                binding.tvAppVersion.text = appVersionData.APP_VERNM + "\n" + BuildConfig.VERSION_CODE + "\n" + BuildConfig.VERSION_NAME
            }
        })

        viewModel.exceptionMessage.observe(this, Observer {
            it?.let { message ->
                PostDialog(
                    this@SplashActivity,
                    Constants.DIALOG_TYPE_UPDATE_NEED,
                    this@SplashActivity,
                    getString(R.string.dialog_confirm_delete)
                ).show()
                Timber.e("$message")
            }
        })
    }

    override fun onClick(v: View?) {
        v?.let {
            when (v.getId()) {
                // 삭제 onClick
                R.id.rlNoticeLayoutCloseBtn -> {
                }
            }
        }
    }
}