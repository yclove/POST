package com.ycengine.post.data.dto

import android.arch.persistence.room.Entity
import com.fasterxml.jackson.annotation.JsonProperty

// POST 컬러 테이블
@Entity(
    tableName = "tblColor",
    primaryKeys = ["ici"]
)
data class ColorModel(
    @JsonProperty("ICI")
    val ici: String,
    @JsonProperty("COLOR_CODE")
    val code: String,
    @JsonProperty("SORT_ORDER")
    val sortOrder: Int,
    @JsonProperty("ICON_NM")
    val iconNm: String
)

enum class DownloadStatus {
    PENDING, DOWNLOADING, COMPLETE, FAILURE, UNKNOWN
}