package com.ycengine.post.data.model

import android.arch.persistence.room.Entity
import com.fasterxml.jackson.annotation.JsonProperty

// 인기 노래 검색어 테이블
@Entity(
    tableName = "tblMusPopKeyword",
    primaryKeys = ["keyword"]
)
data class MusPopKeywordModel(
    @JsonProperty("RANKING")
    val ranking: Int,
    @JsonProperty("KEYWORD")
    val keyword: String
)