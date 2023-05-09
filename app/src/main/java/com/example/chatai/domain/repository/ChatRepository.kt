package com.example.chatai.domain.repository

import com.example.chatai.data.dto.ChatDto
import com.example.chatai.domain.model.ChatModel
import com.example.chatai.domain.util.Resource

interface ChatRepository {

    suspend fun getChatData(completion: ChatDto): Resource<ChatModel>

}