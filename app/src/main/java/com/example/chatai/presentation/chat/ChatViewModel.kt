package com.example.chatai.presentation.chat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatai.data.mappers.toChatRequestDto
import com.example.chatai.domain.model.ChatRequest
import com.example.chatai.domain.repository.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository
): ViewModel() {

    var state by mutableStateOf(ChatState())
        private set

    fun onEvent(event: ChatEvent) {
        when (event) {
            is ChatEvent.sendMessage -> {
                viewModelScope.launch {
                    val complitionRequest = ChatRequest(
                        value = state.text
                    ).toChatRequestDto()

                    state.userMessage = state.text
                    state.text = ""

                    try {
                        repository.getChatData(complitionRequest).let { data ->
                            state.botMessage = data.message ?: "Bot can`t answear!"
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    } catch (e: HttpException) {
                        e.printStackTrace()
                    }
                }
            }

            is ChatEvent.enteredMessage -> {
                state.text = event.text
            }
        }
    }
}