package com.ycengine.post.data.model

import android.arch.persistence.room.Entity
import com.fasterxml.jackson.annotation.JsonProperty

// 인기 해시태그 검색어 테이블
@Entity(
    tableName = "tblHashPopKeyword",
    primaryKeys = ["keyword"]
)
data class HashPopKeywordModel(
    @JsonProperty("RANKING")
    val ranking: Int,
    @JsonProperty("KEYWORD")
    val keyword: String,
    @JsonProperty("COUNT")
    val count: Int
)