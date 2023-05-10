package com.example.chatai.presentation.chat.compose

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatai.presentation.chat.ChatEvent
import com.example.chatai.presentation.chat.ChatViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatPresentation(
    viewModel: ChatViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column() {
            Text(
                text = state.botMessage
            )
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