package com.example.chatai.data.dto

import com.squareup.moshi.Json

data class UsageDto(
    @field:Json(name = "prompt_tokens")
    val prompt_tokens: Int,
    @field:Json(name = "completion_tokens")
    val completion_tokens: Int,
    @field:Json(name = "total_tokens")
    val total_tokens: Int
)