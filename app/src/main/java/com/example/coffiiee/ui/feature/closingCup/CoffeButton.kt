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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.coffiiee.R
import com.example.coffiiee.ui.component.CustomizeButtonBackground

@Composable
fun CoffeeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    var direction by remember { mutableStateOf(1f) }
    val offset by animateDpAsState(
        targetValue = if (direction == 1f) 40.dp else -1.dp,
        animationSpec = tween(300),
    )
    val backgrounColor by animateColorAsState(
        targetValue = if (direction == 1f) Color(0xFFFFEEE7) else Color(0xFF7C351B),
        animationSpec = tween(300),
    )

    CustomizeButtonBackground(
        modifier.width(78.dp),
        color = backgrounColor
    ) {
        IconButton(
            onClick = {
                direction = if (direction == 1f) -1f else 1f
                onClick()
            },
            modifier = modifier.graphicsLayer {
                translationX = offset.toPx()
            }
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(R.drawable.coffeebutton),
                    contentDescription = "Coffee",
                    Modifier.size(40.dp)
                )
            }
        }
        val offsetSwitchStatus = if (direction != 1f) 40.dp else -1.dp

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            SwitchStatus(direction = direction)
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SwitchStatus(
    direction: Float,
    modifier: Modifier = Modifier,
) {
    val backgroundText = if (direction == 1f) "ON" else "Off"
    val alignmentLinetext = if (direction == 1f) TextAlign.Start else TextAlign.End

    AnimatedContent(targetState = backgroundText, transitionSpec = {
        fadeIn(animationSpec = tween(300)) with fadeOut(animationSpec = tween(300))
    }) { targetText ->

        Text(
            targetText,
            modifier = Modifier,
            color = Color.White,
            textAlign = alignmentLinetext
        )
    }
}
