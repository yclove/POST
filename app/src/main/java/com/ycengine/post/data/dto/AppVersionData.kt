package com.ycengine.post.data.dto

data class AppVersionData(
    val MESSAGE: String = "",
    val CODE: String = "",
    val RESPONSE: AppVersionData1
)

data class AppVersionData1(
    val APP_VER: Int = 0,
    val CPS_UPD_YN: String = "",
    val APP_VERNM: String = "",
    val LIKE_ICI: String = "",
    val COUNTRY_CODE: String = "",
    val POST_INTRO_BG: String = "",
    val COLOR: List<ColorItem>? = null,
    val HASH_POP_KEYWORD: List<PostHashTagKeyWordItem>? = null,
    val POST_POP_KEYWORD: List<MusPopKeyWordItem>? = null,
    val MUS_POP_KEYWORD: List<MusPopKeyWordItem>? = null,
    val NOTI_SETTING: List<NotiSettingItem>? = null
)