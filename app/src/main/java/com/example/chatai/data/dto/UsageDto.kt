package com.example.chatai.data.dto

import com.squareup.moshi.Json

data class UsageDto(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int
)