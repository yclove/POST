package com.ycengine.post.repository.remote

import android.os.Build
import android.webkit.CookieManager
import android.webkit.CookieSyncManager
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class WebCookieJar : CookieJar {

    override fun saveFromResponse(url: HttpUrl?, cookies: MutableList<Cookie>?) {
        cookies?.forEach {
            CookieManager.getInstance().setCookie(url?.host() ?: "", it.toString())
        }

        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().sync()
        }
    }

    override fun loadForRequest(url: HttpUrl?): MutableList<Cookie> {
        val webCookies = CookieManager.getInstance().getCookie(url?.host())
        val cookies = arrayListOf<Cookie>()
        webCookies.split(";").map { itCookie ->
            Cookie.parse(url!!, itCookie)?.let { cookies.add(it) }
        }
        return cookies
    }
}