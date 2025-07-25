package com.example.coffiiee.ui.feature.customizeCoffe

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffiiee.ui.component.CircleButton
import com.example.coffiiee.ui.viewModel.CupSizeViewModel

@Composable
fun ButtonAnimation(
    text: String,
    buttonName: String,
    viewModel: CupSizeViewModel
) {
    val state by viewModel.state.collectAsState()
    val isSelected = state.selectedButton == buttonName
    val shadow = animateDpAsState(targetValue = if (isSelected) 8.dp else 0.dp, label = "shadow")
    val color by animateColorAsState(
        targetValue = if (isSelected) Color(0xFF7C351B) else Color(0xFFF5F5F5),
        animationSpec = tween(400),
    )
    val colorText by animateColorAsState(
        targetValue = if (!isSelected) Color(0x991F1F1F) else Color(0xFFFFFFDE),
        animationSpec = tween(400),
    )
    CircleButton(
        onClick = { viewModel.onButtonPressed(buttonName) },
        shadow = shadow,
        color = color,modifier= Modifier.padding(8.dp)
    ) {
        Text(
            text = text,
            color = colorText,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

