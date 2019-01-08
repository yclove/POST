package com.ycengine.post.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.ycengine.post.R
import com.ycengine.post.common.base.BaseActivity
import com.ycengine.post.databinding.ActivityPostBinding
import com.ycengine.post.regist.RegistUserFragment

class PostActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPostBinding
    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)

        viewModel = ViewModelProviders
            .of(this)
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
                }
            }
        })
    }

    override fun onClick(v: View?) {
        v?.let {
            when (v.id) {
                // 삭제 onClick
                R.id.rlNoticeLayoutCloseBtn -> {
                }
            }
        }
    }
}