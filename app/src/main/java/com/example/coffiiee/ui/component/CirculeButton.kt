package com.example.coffiiee.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun CircleButton(
    onClick: () -> Unit,
    shadow: State<Dp>,
    color: Color,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .graphicsLayer {
                shadowElevation = shadow.value.toPx()
                shape = CircleShape
                clip = true
            }
            .background(color)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

