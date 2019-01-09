package com.ycengine.post.common

import android.databinding.BindingAdapter
import android.view.View
import com.ycengine.post.R

@BindingAdapter("countryCode")
fun setCountryCode(view: View, countryCode: String?) {
    countryCode?.let {
        if (!it.equals("KR", ignoreCase = true)) {
            view.visibility = View.VISIBLE

            view.findViewById<View>(R.id.rlLimitServiceCloseBtn).setOnClickListener {
                view.visibility = View.GONE
            }

            view.findViewById<View>(R.id.llLimitServiceConfirmBtn).setOnClickListener {
                view.visibility = View.GONE
            }
        }
    }
}