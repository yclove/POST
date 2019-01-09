package com.ycengine.post.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OstDataItem(
    var POST_TYPE: String = "",
    var POST_UAI: String = "",
    var UAI: String = "",
    var OTI: String = "",
    var POI: String = "",
    var SSI: String = "",
    var REG_DATE: String = "",
    var TITL_TOGGLE_YN: String = "",
    var CONT: String = "",
    var SONG_NM: String = "",
    var ARTI_NM: String = "",
    var COLOR: String = "",
    var COLOR_HEX: String = "",
    var EMOTICON: String = "",
    var LIKE_TOGGLE_YN: String = "",
    var LIKE_CNT: String = "",
    var DCRE_CNT: String = "",
    var DCRE_TOGGLE_YN: String = "",
    var OST_REPLY_CNT: String = "",
    var OST_REPLY_YN: String = "",
    var ALBUM_PATH: String = "",
    var RADIO_PATH: String = "",
    var ADD_DATE: String = "",
    var OST_YN: String = "",
    var isChecked: Boolean = false,
    var intPlayState: Int = 0
) : Parcelable