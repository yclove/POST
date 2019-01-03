package com.ycengine.post.data.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OstDataItem(
    val POST_TYPE: String = "",
    val POST_UAI: String = "",
    val UAI: String = "",
    val OTI: String = "",
    val POI: String = "",
    val SSI: String = "",
    val REG_DATE: String = "",
    val TITL_TOGGLE_YN: String = "",
    val CONT: String = "",
    val SONG_NM: String = "",
    val ARTI_NM: String = "",
    val COLOR: String = "",
    val COLOR_HEX: String = "",
    val EMOTICON: String = "",
    val LIKE_TOGGLE_YN: String = "",
    val LIKE_CNT: String = "",
    val DCRE_CNT: String = "",
    val DCRE_TOGGLE_YN: String = "",
    val OST_REPLY_CNT: String = "",
    val OST_REPLY_YN: String = "",
    val ALBUM_PATH: String = "",
    val RADIO_PATH: String = "",
    val ADD_DATE: String = "",
    val OST_YN: String = "",
    val isChecked: Boolean = false,
    val intPlayState: Int = 0
) : Parcelable