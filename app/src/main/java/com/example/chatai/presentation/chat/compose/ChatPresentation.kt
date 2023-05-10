package com.example.chatai.presentation.chat.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatai.domain.model.MessageModel
import com.example.chatai.domain.model.SenderEnum
import com.example.chatai.presentation.chat.ChatEvent
import com.example.chatai.presentation.chat.ChatViewModel
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatPresentation(
    viewModel: ChatViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize(),
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .weight(1f)
            ) {
                items(state.messages) {
                    MessagePresentation(message = it)
                    Spacer(modifier = Modifier.height(8.dp))
                }

                item {
                    if (state.duringSending) {
                        MessagePresentation(message = MessageModel(
                            message = "Taping...",
                            sender = SenderEnum.BOT,
                            time = Calendar.getInstance().timeInMillis
                        ))
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TextField(
                    value = state.text,
                    onValueChange = {
                        viewModel.onEvent(ChatEvent.enteredMessage(it))
                    },
                    modifier = Modifier
                        .weight(1f)
                )
                
                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        viewModel.onEvent(ChatEvent.sendMessage)
                    }
                ) {
                    Text(text = "Send Message")
                }
            }
        }
    }
    
}