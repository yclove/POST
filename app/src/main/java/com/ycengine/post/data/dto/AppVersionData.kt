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
    val arrColorItem: List<ColorItem>? = null,
    @JsonProperty("HASH_POP_KEYWORD")
    val arrPostHashTagKeyWordItem: List<PostHashTagKeyWordItem>? = null,
    @JsonProperty("POST_POP_KEYWORD")
    val arrPostPopKeyWordItem: List<MusPopKeyWordItem>? = null,
    @JsonProperty("MUS_POP_KEYWORD")
    val arrMusPopKeyWordItem: List<MusPopKeyWordItem>? = null,
    @JsonProperty("NOTI_SETTING")
    val arrNotiSettingItem: List<NotiSettingItem>? = null
)