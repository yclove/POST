package com.ycengine.post.data.model

import android.arch.persistence.room.Entity
import com.fasterxml.jackson.annotation.JsonProperty

// 인기 이야기 검색어 테이블
@Entity(
    tableName = "tblPostPopKeyword",
    primaryKeys = ["keyword"]
)
data class PostPopKeywordModel(
    @JsonProperty("RANKING")
    val ranking: Int,
    @JsonProperty("KEYWORD")
    val keyword: String
)