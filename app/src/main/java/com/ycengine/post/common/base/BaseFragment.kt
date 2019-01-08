package com.ycengine.post.common.base

import android.graphics.Color
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import com.ycengine.post.R
import com.ycengine.post.common.Constants
import kotlinx.android.synthetic.main.view_post_header.*

abstract class BaseFragment : Fragment() {

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

    fun setPostHeader(headerType: Int, onClickListener: View.OnClickListener, vararg args: String) {
        btnHeaderMenu.setOnClickListener(onClickListener)
        btnHeaderBack.setOnClickListener(onClickListener)
        btnHeaderTitleLayout.setOnClickListener(onClickListener)
        btnHeaderCheck.setOnClickListener(onClickListener)
        btnHeaderClose.setOnClickListener(onClickListener)
        btnHeaderTimeLine.setOnClickListener(onClickListener)
        llPopularBtn.setOnClickListener(onClickListener)

        btnHeaderMenu.visibility = View.GONE
        btnHeaderBack.visibility = View.GONE
        btnHeaderCheck.visibility = View.GONE
        btnHeaderTimeLine.visibility = View.GONE
        btnHeaderClose.visibility = View.GONE
        llPopularBtn.visibility = View.GONE

        when(headerType) {
            Constants.HEADER_TYPE_MENU -> {
                btnHeaderMenu.visibility = View.VISIBLE
                btnHeaderTimeLine.visibility = View.VISIBLE
            }
            Constants.HEADER_TYPE_BACK_HOME_CHECK -> {
                btnHeaderBack.visibility = View.VISIBLE
                btnHeaderCheck.visibility = View.VISIBLE
            }
            Constants.HEADER_TYPE_BACK_HOME -> {
                btnHeaderBack.visibility = View.VISIBLE
            }
            Constants.HEADER_TYPE_CLOSE -> {
                btnHeaderClose.visibility = View.VISIBLE
            }
            Constants.HEADER_TYPE_MENU_POPULAR -> {
                btnHeaderMenu.visibility = View.VISIBLE
                llPopularBtn.visibility = View.VISIBLE
                lstvPopularText.spacing = Constants.TEXT_VIEW_SPACING

                when(args[0]) {
                    Constants.REQUEST_TYPE_POST -> {
                        lstvPopularText.text = getString(R.string.post)
                        lstvPopularText.setTextColor(Color.parseColor("#FF00AFD5"))
                    }
                    Constants.REQUEST_TYPE_RADIO -> {
                        lstvPopularText.text = getString(R.string.radio)
                        lstvPopularText.setTextColor(Color.parseColor("#FFF65857"))
                    }
                    Constants.REQUEST_TYPE_TODAY -> {
                        lstvPopularText.text = getString(R.string.today)
                        lstvPopularText.setTextColor(Color.parseColor("#FFFFD83B"))
                    }
                }
            }
        }
    }
}