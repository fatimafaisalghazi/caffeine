package com.example.coffiiee.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Button(
            onClick = { onClick() },
            colors = ButtonColors(
                containerColor = Color(0xFF1F1F1F),
                contentColor = Color(0xFFFFFFFF),
                disabledContainerColor = Color(0xFF121212),
                disabledContentColor = Color(0x88FFFFFF)
            ),
        ) {
            Row(
                modifier.padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                content()
            }

        }
    }
}