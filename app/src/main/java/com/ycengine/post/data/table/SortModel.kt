package com.ycengine.post.data.table

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index

@Entity(
    tableName = "tblSort",
    primaryKeys = ["sortType"],
    indices = [(Index(value = ["sortType"]))]
)
data class SortModel(
    var userId: String,
    val sortType: String,
    val sortGender: String,
    val sortGeneration: String,
    val sortTime: String,
    val sortDistance: String,
    val sortDate: String
)