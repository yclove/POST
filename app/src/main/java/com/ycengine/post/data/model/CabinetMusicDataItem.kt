package com.ycengine.post.data.model

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CabinetMusicDataItem(
    var SORT_ORDER: String = "",
    var BXI: String = "",
    var SSI: String = "",
    var POI: String = "",
    var OTI: String = "",
    var SONG_NM: String = "",
    var ARTI_NM: String = "",
    var OTI_DEL_YN: String = "",
    var POI_DISP_YN: String = "",
    var POST_TYPE: String = "",
    var REG_DATE: String = "",
    var ALBUM_PATH: String = "",
    var TITL_TOGGLE_YN: String = ""
) : Parcelable {
    @IgnoredOnParcel
    var isChecked: Boolean = false
}