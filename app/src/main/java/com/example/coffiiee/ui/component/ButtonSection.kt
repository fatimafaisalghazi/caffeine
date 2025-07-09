package com.example.coffiiee.ui.component

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun ButtonSection(
    text: String,
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ActionButton(
        onClick = { onClick() },
        modifier.navigationBarsPadding(),
    ) {
        ButtonText(text = text)
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color(0xDEFFFFFF),
            modifier = Modifier
                .size(24.dp)
        )
    }
}
