package com.ycengine.post.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.ycengine.post.R
import com.ycengine.post.common.base.BaseActivity
import com.ycengine.post.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        viewModel = ViewModelProviders
            .of(this)
            .get(SplashViewModel::class.java)

        viewModel.appVersionData.observe(this, Observer {
            it?.let { appVersionData ->
                binding.tvAppVersion.text = appVersionData.RESPONSE.APP_VERNM
            }
        })
    }
}