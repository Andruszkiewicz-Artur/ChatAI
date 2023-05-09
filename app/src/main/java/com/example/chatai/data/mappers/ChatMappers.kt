package com.example.chatai.data.mappers

import com.example.chatai.data.dto.ChatDto
import com.example.chatai.domain.model.ChatModel

fun ChatDto.toChatMap(): ChatModel {
    return ChatModel(
        text = choices[0].text,
        model = model
    )
}