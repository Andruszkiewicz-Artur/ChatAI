package com.example.chatai.presentation.chat

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatai.data.mappers.toChatRequestDto
import com.example.chatai.domain.model.ChatRequest
import com.example.chatai.domain.repository.ChatRepository
import com.example.chatai.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository
): ViewModel() {

    private val _state = mutableStateOf(ChatState())
    val state: State<ChatState> = _state

    fun onEvent(event: ChatEvent) {
        when (event) {
            is ChatEvent.sendMessage -> {
                viewModelScope.launch {
                    val complitionRequest = ChatRequest(
                        value = _state.value.text
                    ).toChatRequestDto()

                    _state.value = state.value.copy(
                        text = "",
                        userMessage = _state.value.text
                    )

                    when (val result = repository.getChatData(complitionRequest)) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                botMessage = result.data?.text ?: "Bot can`t answear!"
                            )

                            Log.d("bot", _state.value.botMessage)
                        }
                        is Resource.Error -> {
                            Log.d("Error", "Error during taking data")
                        }
                    }
                }
            }

            is ChatEvent.enteredMessage -> {
                _state.value = state.value.copy(
                    text = event.text
                )
            }
        }
    }
}