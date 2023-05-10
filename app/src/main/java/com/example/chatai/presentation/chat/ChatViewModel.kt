package com.example.chatai.presentation.chat

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatai.data.mappers.toChatRequestDto
import com.example.chatai.domain.model.ChatRequest
import com.example.chatai.domain.model.MessageModel
import com.example.chatai.domain.model.SenderEnum
import com.example.chatai.domain.repository.ChatRepository
import com.example.chatai.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception
import java.util.Calendar
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
                if (_state.value.text.isNotBlank()) {
                    viewModelScope.launch {
                        _state.value = state.value.copy(
                            duringSending = true
                        )

                        val complitionRequest = ChatRequest(
                            value = _state.value.text
                        ).toChatRequestDto()

                        addNewMessage(
                            message = _state.value.text,
                            sender = SenderEnum.USER
                        )

                        when (val result = repository.getChatData(complitionRequest)) {
                            is Resource.Success -> {
                                addNewMessage(
                                    message = result.data?.text ?: "Bot can`t answear!",
                                    sender = SenderEnum.BOT
                                )
                            }
                            is Resource.Error -> {
                                Log.d("Error", "Error during taking data")
                            }
                        }

                        _state.value = state.value.copy(
                            duringSending = false
                        )
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

    private fun addNewMessage(message: String, sender: SenderEnum) {
        if (sender == SenderEnum.USER) {
            _state.value = state.value.copy(
                text = ""
            )
        }

        _state.value.messages.add(
            MessageModel(
                message = message.replace("\n", ""),
                sender = sender,
                time = Calendar.getInstance().timeInMillis
            )
        )
    }
}