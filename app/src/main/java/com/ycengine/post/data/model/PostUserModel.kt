package com.ycengine.post.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class PostUserModel(
    @JsonProperty("PUSH_ID")
    val pushId: String = "",
    @JsonProperty("BIRTHDATE")
    val birthDate: String,
    @JsonProperty("GENDER")
    val gender: String,
    @JsonProperty("ACCOUNT_ID")
    val accountId: String = "",
    @JsonProperty("ACCOUNT_AUTH_TYPE")
    val accountAuthType: String = "",
    @JsonProperty("PUSH_IDS")
    val pushDataList: List<PushDataModel> = listOf()
)

data class PushDataModel(
    @JsonProperty("PUSH_ID")
    val pushId: String,
    @JsonProperty("UAI")
    val uai: String,
    @JsonProperty("DEVI_TYPE")
    val deviType: String
)