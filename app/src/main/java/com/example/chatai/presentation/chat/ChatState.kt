package com.example.chatai.presentation.chat

data class ChatState (
    val userMessage: String = "",
    val botMessage: String = "",
    val text: String = ""
)