package com.ycengine.post.common.base

import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

abstract class RxBaseActivity : AppCompatActivity() {

    val compositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }
}