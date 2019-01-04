package com.ycengine.post.data.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AppVersionData(
    val APP_VER: Int = 0,
    val CPS_UPD_YN: String = "",
    val APP_VERNM: String = "",
    val LIKE_ICI: String = "",
    val COUNTRY_CODE: String = "",
    val POST_INTRO_BG: String = "",
    @JsonProperty("COLOR")
    val arrColorItem: ArrayList<ColorItem>? = null,
    @JsonProperty("HASH_POP_KEYWORD")
    val arrPostHashTagKeyWordItem: ArrayList<PostHashTagKeyWordItem>? = null,
    @JsonProperty("POST_POP_KEYWORD")
    val arrPostPopKeyWordItem: ArrayList<MusPopKeyWordItem>? = null,
    @JsonProperty("MUS_POP_KEYWORD")
    val arrMusPopKeyWordItem: ArrayList<MusPopKeyWordItem>? = null,
    @JsonProperty("NOTI_SETTING")
    val arrNotiSettingItem: ArrayList<NotiSettingItem>? = null
)