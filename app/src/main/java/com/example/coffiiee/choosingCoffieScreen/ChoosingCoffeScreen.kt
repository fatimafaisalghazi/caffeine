package com.example.coffiiee.choosingCoffieScreen


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffiiee.HomeScreenAppBar
import com.example.coffiiee.R
import kotlin.math.abs

@Composable
fun ChoosingCoffeeScreen() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        HomeScreenAppBar()

        Box(Modifier.offset(x = -65.dp)) {
            WelcomeMessage()
        }
        CoffeeCup()
        ButtonSection()
    }
}

@Composable
private fun WelcomeMessage(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            "Good Morning",
            fontSize = 36.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Start,
            color = Color(0xFFB3B3B3)
        )
        Text(
            "Hamsa ☀",
            fontSize = 36.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Start,
            color = Color(0xFF3B3B3B)
        )
        Text(
            "What would you like to drink today?",
            fontSize = 16.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Start,
            color = Color(0xCC1F1F1F)
        )
    }
}


@Composable
private fun ButtonSection(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Button(
            onClick = {},
            colors = ButtonColors(
                containerColor = Color(0xFF1F1F1F),
                contentColor = Color(0xFFFFFFFF),
                disabledContainerColor = Color(0xFF121212),
                disabledContentColor = Color(0x88FFFFFF)
            ),
        ) {
            Row(
                Modifier.padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Continue",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 18.5.dp),
                )
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun CoffeeCup(
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = { 4 })

    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp),
        contentPadding = PaddingValues(horizontal = 60.dp),

    ) { page ->
        val pageOffSet = calculatePageOffset(
            pagerState = pagerState,
            currentPage = page,
            pageFraction = pagerState.currentPageOffsetFraction
        )
        val baseScale = 1.4f
        val maxScale = 1.8f

        val scale = baseScale + (1 - abs(pageOffSet)) * (maxScale - baseScale)

        val animateScale = animateFloatAsState(
            scale,
            animationSpec = tween(700),
        )
        val imageSize = 200.dp

        Box(
            Modifier.padding(horizontal = 60.dp)
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


