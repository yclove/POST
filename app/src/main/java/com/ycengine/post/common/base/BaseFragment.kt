package com.ycengine.post.common.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

abstract class BaseFragment : RxBaseFragment() {

    fun pushFragment(manager: FragmentManager, fragment: Fragment, containerResId: Int, tag: String, animated: Boolean) {
        pushFragment(manager, fragment, containerResId, tag, true, animated)
    }

    fun pushFragment(manager: FragmentManager, fragment: Fragment, containerResId: Int, tag: String, addToBackStack: Boolean, animated: Boolean) {
        val transaction = manager.beginTransaction()

        if (animated) {
//            transaction.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_in, R.anim.slide_left_out, R.anim.slide_right_out)
        }

        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }

        transaction.add(containerResId, fragment, tag)
        transaction.commit()
    }

    private fun topFragment(): Fragment? {
        val fragmentList = childFragmentManager.fragments
        return if (fragmentList.isEmpty()) null else fragmentList[fragmentList.size - 1]
    }
}