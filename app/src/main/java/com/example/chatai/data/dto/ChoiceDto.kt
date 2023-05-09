package com.example.chatai.data.dto

import com.squareup.moshi.Json

data class ChoiceDto(
    @field:Json(name = "text")
    val text: String,
    @field:Json(name = "index")
    val index: Int,
    @field:Json(name = "logprobs")
    val logprobs: Any?,
    @field:Json(name = "finish_reason")
    val finish_reason: String
)
