package com.example.myapplication.components.navigation.example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(navigateBack: () -> Unit, navigateToDetail: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        Text("HOME", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Row {
            TextField(value = text, onValueChange = { text = it }, modifier = Modifier.weight(1f))
            Button(onClick = { navigateToDetail(text) }) {
                Text("Detail")
            }
        }
        Spacer(Modifier.weight(1f))
        Button(onClick = { navigateBack() }) {
            Text("Atrás")
        }
        Spacer(Modifier.weight(1f))
    }
}