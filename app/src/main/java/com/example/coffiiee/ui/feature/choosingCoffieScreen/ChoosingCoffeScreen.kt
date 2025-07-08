package com.example.coffiiee.ui.feature.choosingCoffieScreen


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffiiee.ui.component.HomeScreenAppBar
import com.example.coffiiee.R
import com.example.coffiiee.ui.component.ActionButton
import com.example.coffiiee.ui.component.ButtonText
import com.example.coffiiee.ui.component.WelcomeMessageText
import com.example.coffiiee.navigation.LocalNavController
import com.example.coffiiee.navigation.Routes
import com.example.coffiiee.ui.component.ButtonSection
import kotlin.math.abs

@Composable
fun ChoosingCoffeeScreen() {
    val navController = LocalNavController.current
    val pagerState: PagerState = rememberPagerState(3) { 4 }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        HomeScreenAppBar()
        WelcomeMessage()
        CoffeeCup(pagerState)

        ButtonSection(
            text = "Continue", icon = painterResource(R.drawable.arrow_right),
            onClick = { navController.navigate(Routes.CustomizeCoffeeScreen(index = pagerState.currentPage)) })
    }

}

@Composable
private fun WelcomeMessage(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
    ) {
        WelcomeMessageText(text = "Good Morning", textSize = 36)
        WelcomeMessageText(text = "Hamsa ☀", textSize = 36)
        WelcomeMessageText(text = "What would you like to drink today?", textSize = 16)
    }
}

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

@Preview(showBackground = true)
@Composable
fun xdrfvygbnj() {
    ChoosingCoffeeScreen()
}



