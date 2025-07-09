package com.example.coffiiee.ui.feature.closingCup

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.coffiiee.R

@Composable
fun CoffeeSwitch(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    var direction by remember { mutableFloatStateOf(1f) }

    val offset by animateDpAsState(
        targetValue = if (direction != 1f) (-1).dp else 40.dp,
        animationSpec = tween(300),
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (direction != 1f) Color(0xFF7C351B) else Color(0xFFFFEEE7),
        animationSpec = tween(300),
    )


    Box(
        modifier = modifier
            .size(78.dp, 40.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(backgroundColor)
            .clickable(
                onClick = {
                    direction = -direction
                    onClick()
                }
            )
    ) {
        Box(
            modifier = Modifier

                .graphicsLayer {
                    translationX = offset.toPx()
                }) {
            Image(
                painter = painterResource(R.drawable.coffeebutton),
                contentDescription = "Coffee",
                modifier = Modifier.size(40.dp)
            )
        }

        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            SwitchStatus(direction = direction)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SwitchStatus(
    direction: Float,
    modifier: Modifier = Modifier
) {
    val label = if (direction != 1f) "ON" else "OFF"
    val textAlign = if (direction != 1f) TextAlign.End else TextAlign.Start

    AnimatedContent(
        targetState = label,
        transitionSpec = {
            fadeIn(animationSpec = tween(300)) with fadeOut(animationSpec = tween(300))
        }
    ) { targetText ->
        Text(
            text = targetText,
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth(),
            color = if(direction != 1f ) Color(0x99FFFFFF) else Color(0x99000000),
            textAlign = textAlign,
        )
    }
}
