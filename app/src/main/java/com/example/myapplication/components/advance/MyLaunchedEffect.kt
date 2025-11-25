package com.example.myapplication.components.advance

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun MyLaunchedEffect(modifier: Modifier = Modifier, onFinished: () -> Unit) {
    var timeLeft by remember { mutableIntStateOf(5) }

    LaunchedEffect(timeLeft) {
        if (timeLeft > 0) {
            delay(1000)
            timeLeft--
        } else {
            onFinished()
        }
    }

    Box(modifier = Modifier.size(150.dp), contentAlignment = Alignment.Center) {
        Text(text = if (timeLeft > 0) timeLeft.toString() else "Boom!", fontSize = 30.sp)
    }
}