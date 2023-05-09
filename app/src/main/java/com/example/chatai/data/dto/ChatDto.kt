package com.example.chatai.data.dto

import com.squareup.moshi.Json

data class ChatDto(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "obj")
    val obj: String,
    @field:Json(name = "created")
    val created: Long,
    @field:Json(name = "model")
    val model: String,
    @field:Json(name = "choices")
    val choices: List<ChoiceDto>,
    @field:Json(name = "usage")
    val usage: UsageDto
)
