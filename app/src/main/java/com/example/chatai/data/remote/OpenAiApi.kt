package com.example.chatai.data.remote

import com.example.chatai.data.dto.ChatDto
import com.example.chatai.data.dto.ChatRequestDto
import com.example.chatai.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAiApi {

    @Headers("Authorization: Bearer $api_key")
    @POST("v1/completions")
    suspend fun getAnswear(
        @Body completion: ChatRequestDto
    ): ChatDto

    companion object {
        const val api_key = "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"
    }
}