package com.ycengine.post.data.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AppVersionModel(
    val APP_VER: Int = 0,
    val CPS_UPD_YN: String = "",
    val APP_VERNM: String = "",
    val LIKE_ICI: String = "",
    val COUNTRY_CODE: String = "",
    val POST_INTRO_BG: String = "",
    @JsonProperty("COLOR")
    val arrColorItem: ArrayList<ColorModel>? = null,
    @JsonProperty("HASH_POP_KEYWORD")
    val arrPostHashTagKeyWordItem: ArrayList<HashPopKeywordModel>? = null,
    @JsonProperty("POST_POP_KEYWORD")
    val arrPostPopKeyWordItem: ArrayList<PostPopKeywordModel>? = null,
    @JsonProperty("MUS_POP_KEYWORD")
    val arrMusPopKeyWordItem: ArrayList<MusPopKeywordModel>? = null,
    @JsonProperty("NOTI_SETTING")
    val arrNotiSettingItem: ArrayList<NotiSettingModel>? = null
)