package com.ycengine.post.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class RegistUserModel(
    @JsonProperty("UAI")
    val UAI: String
)