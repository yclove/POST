package com.ycengine.post.repository.remote

object ApiCache {

    private const val HEADER_CACHE_CONTROL = "Cache-Control"
    const val NO_CACHE = "$HEADER_CACHE_CONTROL:no-cache"
    const val CACHE_DEFAULT = "$HEADER_CACHE_CONTROL:max-age=180"
    const val CACHE_LONG = "$HEADER_CACHE_CONTROL:max-age=3600"
}