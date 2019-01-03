package com.ycengine.post.common.base

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable

abstract class RxBaseFragment : Fragment() {

    val globalCompositeDisposable: CompositeDisposable? = CompositeDisposable()
    val compositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }
}