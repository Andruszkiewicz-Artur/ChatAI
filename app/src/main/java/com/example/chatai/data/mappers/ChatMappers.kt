package com.example.chatai.data.mappers

import com.example.chatai.data.dto.ChatDto
import com.example.chatai.data.dto.ChatRequestDto
import com.example.chatai.domain.model.ChatModel
import com.example.chatai.domain.model.ChatRequest

fun ChatDto.toChatModel(): ChatModel {
    return ChatModel(
        text = choices[0].text,
        model = model
    )
}

fun ChatRequest.toChatRequestDto(): ChatRequestDto {
    return ChatRequestDto(
        model = "text-davinci-003",
        prompt = value,
        max_tokens = 4000
    )
}