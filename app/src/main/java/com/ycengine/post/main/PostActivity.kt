package com.ycengine.post.main

import android.arch.lifecycle.*
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.ycengine.post.R
import com.ycengine.post.common.Constants
import com.ycengine.post.common.PostException
import com.ycengine.post.common.base.BaseActivity
import com.ycengine.post.databinding.ActivityPostBinding
import com.ycengine.post.regist.RegistUserFragment
import com.ycengine.post.widget.PostDialog
import timber.log.Timber

class PostActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPostBinding
    private lateinit var viewModel: PostViewModel
    private var postDialog: PostDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)

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

        viewModel.postException.observe(this, Observer {
            it?.let { e ->
                when (e.code) {
                    PostException.SW_UPDATE_NEEDED -> {
                        if (!isFinishing) {
                            postDialog = createGlobalDialog(Constants.DIALOG_EXCEPTION_UPDATE_NEED, true)?.apply {
                                show()
                            }
                        }
                    }
                    PostException.SW_UPDATE_SUPPORT -> {
                        if (!isFinishing) {
                            postDialog = createGlobalDialog(Constants.DIALOG_EXCEPTION_UPDATE_SUPPORT, true)?.apply {
                                show()
                            }
                        }
                    }
                    else -> {
                        postDialog = PostDialog(this, Constants.DIALOG_TYPE_INFO, this, e.message).apply {
                            show()
                        }
                    }
                }
            }
        })
    }

    override fun onClick(v: View?) {
        v?.let {
            when (it.id) {
                // 안내 타입의 확인 onClick
                R.id.btnInfoConfirm -> {
                    postDialog?.takeIf { dialog -> dialog.isShowing }?.apply { dismiss() }
                }
                else -> {
                    Timber.e("The request is else case. request : ${it.resources.getResourceEntryName(it.id)}")
                }
            }
        }
    }
}