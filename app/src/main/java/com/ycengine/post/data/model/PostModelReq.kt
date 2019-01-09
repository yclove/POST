package com.ycengine.post.data.model

data class PostModelReq(
    // 인기 사연 여부
    var POPULAR: String = "N",
    // 포스트 유형
    var POST_TYPE: PostType = PostType.AA01,
    // 페이징 번호
    var CURRENT_PAGE: Int = 1,
    // 성별 설정값
    var GENDER: Gender? = null,

    var TAG: String = "",
    var ICI: String = "",
    var LOCA_LNG: String = "",
    var LOCA_LAT: String = "",
    var SEARCH_DATE: String = "",
    var TIME_ZONE_TYPE: String = "",
    var AGE_ZONE: String = "",
    var DISTANCE: String = "",
    var ALIGN_TYPE: String = "",
    var PLACE: String = ""
)