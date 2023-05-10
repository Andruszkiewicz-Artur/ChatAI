package com.example.chatai.domain.model

data class MessageModel(
    val message: String,
    val sender: SenderEnum,
    val time: Long
)