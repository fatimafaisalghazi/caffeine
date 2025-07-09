package com.example.coffiiee.ui.feature.choosingCoffieScreen

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coffiiee.R
import kotlin.math.abs

@Composable
fun CoffeeCup(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp),
        pageSpacing = 8.dp,
        flingBehavior = PagerDefaults.flingBehavior(
            state = pagerState,
            snapAnimationSpec = tween(
                durationMillis = 800,
                easing = LinearOutSlowInEasing
            )
        ),
        contentPadding = PaddingValues(horizontal = 100.dp, vertical = 56.dp)

    ) { page ->
        val pageOffSet = calculatePageOffset(
            pagerState = pagerState,
            currentPage = page,
            pageFraction = pagerState.currentPageOffsetFraction
        )
        val baseScale = 1.6f
        val maxScale = 2.4f

        val scale = baseScale + (1 - abs(pageOffSet)) * (maxScale - baseScale)

        val animateScale = animateFloatAsState(
            scale,
            animationSpec = tween(300),
        )
        val imageSize = 200.dp

        Box(
            Modifier
                .padding(horizontal = 60.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            when (page) {
                0 -> Image(
                    painter = painterResource(R.drawable.black),
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSize)
                        .graphicsLayer {
                            scaleX = animateScale.value
                            scaleY = animateScale.value
                        }
                )

                1 -> Image(
                    painter = painterResource(R.drawable.latte),
                    contentDescription = null,
                    Modifier
                        .graphicsLayer {
                            scaleX = animateScale.value
                            scaleY = animateScale.value
                        }
                        .size(imageSize)
                )

                2 -> Image(
                    painter = painterResource(R.drawable.espresso),
                    contentDescription = null,
                    Modifier
                        .graphicsLayer {
                            scaleX = animateScale.value
                            scaleY = animateScale.value
                        }
                        .size(imageSize)
                )

                3 -> Image(
                    painter = painterResource(R.drawable.macchiato),
                    contentDescription = null,
                    Modifier
                        .graphicsLayer {
                            scaleX = animateScale.value
                            scaleY = animateScale.value
                        }
                        .size(imageSize)
                )
            }
        }
    }
}

private fun calculatePageOffset(
    pagerState: PagerState,
    currentPage: Int,
    pageFraction: Float
): Float {
    return (currentPage - pagerState.currentPage) + pageFraction
}