package com.example.chatai.domain.model

import com.example.chatai.data.dto.ChoiceDto
import com.example.chatai.data.dto.UsageDto
import com.squareup.moshi.Json

data class ChatModel(
    val text: String?,
    val model: String
)
