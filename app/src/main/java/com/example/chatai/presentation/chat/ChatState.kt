package com.example.chatai.presentation.chat

import com.example.chatai.domain.model.MessageModel

data class ChatState (
    val messages: MutableList<MessageModel> = mutableListOf(),
    val text: String = "",
    val duringSending: Boolean = false
)