package com.example.coffiiee.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.coffiiee.ui.theme.urbaniFamily

@Composable
fun WelcomeMessageText(
    text: String, textSize: Int,
    modifier: Modifier = Modifier,
    color:Color = Color.Unspecified
) {
    Text(
        text = text,
        fontSize = textSize.sp,
        fontWeight = FontWeight.W700,
        fontFamily = urbaniFamily,
        textAlign = TextAlign.Start,
        color = color,
        letterSpacing = 0.25.sp,
        maxLines = 3,
        softWrap = true,
        modifier = modifier
            .fillMaxWidth(0.8f),
    )
}