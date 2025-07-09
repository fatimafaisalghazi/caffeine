package com.example.coffiiee.ui.feature.closingCup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coffiiee.R

@Composable
fun CupWithLid() {
    var lidVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        lidVisible = true
    }


    val cupPainter = painterResource(R.drawable.cup)
    val logoPainter = painterResource(R.drawable.logo)
    val lidPainter = painterResource(R.drawable.lid)

    Box(modifier = Modifier.size(300.dp), contentAlignment = Alignment.Center) {

        Spacer(Modifier.height(24.dp))

        Image(
            painter = cupPainter,
            contentDescription = "Cup",
            modifier = Modifier.size(height = 300.dp, width = 254.dp)
        )
        Image(
            painter = logoPainter,
            contentDescription = "Logo",
            modifier = Modifier.size(64.dp)
        )


    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp

    AnimatedVisibility(
        visible = lidVisible,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> -screenHeightDp },
            animationSpec = tween(durationMillis = 700)
        ),
        exit = ExitTransition.None
    ) {
        Box(
            modifier = Modifier
                .size(300.dp).offset(y=-33.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Image(
                painter = lidPainter,
                contentDescription = "Lid",
                modifier = Modifier.align(Alignment.TopCenter)
                    .graphicsLayer {
                        transformOrigin = TransformOrigin(0.5f, 1f)
                    }
            )
        }
    }
}}
