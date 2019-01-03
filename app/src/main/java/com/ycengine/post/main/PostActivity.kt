package com.ycengine.post.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.ycengine.post.R
import com.ycengine.post.common.base.BaseActivity
import com.ycengine.post.databinding.ActivityPostBinding

class PostActivity : BaseActivity() {

    private lateinit var binding: ActivityPostBinding
    private lateinit var viewModel: PostViewModel

//    private lateinit var adapter: EventRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)

        viewModel = ViewModelProviders
            .of(this)
            .get(PostViewModel::class.java)

//        viewModel
//            .getEventModel()
//            .observe(this, Observer {
//                adapter.notifyDataSetChanged()
//            })
    }
}