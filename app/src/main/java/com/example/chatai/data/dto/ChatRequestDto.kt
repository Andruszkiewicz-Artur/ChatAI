package com.example.chatai.data.dto

data class ChatRequestDto(
    val model: String,
    val prompt: String,
    val max_tokens: Int,
    val temperature: Float = 0f
)
