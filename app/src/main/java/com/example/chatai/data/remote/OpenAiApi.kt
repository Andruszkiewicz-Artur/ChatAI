package com.example.chatai.data.remote

import com.example.chatai.data.dto.ChatDto
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAiApi {

    @Headers("Authorization: Bearer $api_key")
    @POST("v1/completions")
    suspend fun getAnswear(
        @Body completion: ChatDto
    ): ChatDto

    companion object {
        const val api_key = "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"
    }
}