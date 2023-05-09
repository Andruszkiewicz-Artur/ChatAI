package com.example.chatai.data.repository

import com.example.chatai.data.dto.ChatRequestDto
import com.example.chatai.data.mappers.toChatModel
import com.example.chatai.data.remote.OpenAiApi
import com.example.chatai.domain.model.ChatModel
import com.example.chatai.domain.repository.ChatRepository
import com.example.chatai.domain.util.Resource
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val api: OpenAiApi
): ChatRepository {

    override suspend fun getChatData(completion: ChatRequestDto): Resource<ChatModel> {
        return try {
            Resource.Success(
                data = api.getAnswear(
                    completion = completion
                ).toChatModel()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}