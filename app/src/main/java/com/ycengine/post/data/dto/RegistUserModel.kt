package com.ycengine.post.data.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class RegistUserModel(
    @JsonProperty("UAI")
    val UAI: String
)