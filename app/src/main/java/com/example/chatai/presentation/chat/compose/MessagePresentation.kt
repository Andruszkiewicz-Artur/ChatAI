package com.example.chatai.presentation.chat.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatai.domain.model.MessageModel
import com.example.chatai.domain.model.SenderEnum

@Composable
fun MessagePresentation(
    message: MessageModel
) {
    val isUser = message.sender == SenderEnum.USER
    Row(
        horizontalArrangement = if(isUser) Arrangement.End else Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f),
            contentAlignment = if (isUser) Alignment.TopEnd else Alignment.TopStart
        ) {
            Text(
                text = message.message,
                color = if(isUser) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .background(
                        color =  if(isUser) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp)
            )
        }
    }
}