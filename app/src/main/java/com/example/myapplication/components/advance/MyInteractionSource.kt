package com.example.myapplication.components.advance

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InteractionSourceExample(modifier: Modifier = Modifier) {
    val interaction = remember { MutableInteractionSource() }

    val isPressed by interaction.collectIsPressedAsState()
    val isHovered by interaction.collectIsHoveredAsState()

    Box(
        Modifier
            .size(150.dp)
//            .background(if (isPressed) Color.Red else Color.White)
            .shadow(if (isPressed) 12.dp else 4.dp)
            .clickable(interactionSource = interaction, indication = null) { }) {
        Text(if (isPressed) "Pulsado" else "Sin pulsar")
    }
}