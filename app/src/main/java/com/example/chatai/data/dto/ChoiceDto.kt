package com.example.chatai.data.dto

data class ChoiceDto(
    val text: String,
    val index: Int,
    val logprobs: Any?,
    val finish_reason: String
)
