package com.example.chatai.presentation.chat

sealed interface ChatEvent {
    object sendMessage: ChatEvent
    data class enteredMessage(val text: String): ChatEvent
}