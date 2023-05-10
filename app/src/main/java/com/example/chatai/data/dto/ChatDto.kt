package com.example.chatai.data.dto

import com.squareup.moshi.Json

data class ChatDto(
    val id: String,
    val obj: String,
    val created: Long,
    val model: String,
    val choices: List<ChoiceDto>,
    val usage: UsageDto
)
