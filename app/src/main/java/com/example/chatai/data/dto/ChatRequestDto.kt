package com.example.chatai.data.dto

import com.squareup.moshi.Json

data class ChatRequestDto(
    @field:Json(name = "model")
    val model: String,
    @field:Json(name = "prompt")
    val prompt: String,
    @field:Json(name = "max_tokens")
    val max_tokens: Int,
    @field:Json(name = "temperature")
    val temperature: Float = 0f
)
