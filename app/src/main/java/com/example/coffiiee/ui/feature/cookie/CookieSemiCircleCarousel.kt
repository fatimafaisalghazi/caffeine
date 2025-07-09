package com.example.coffiiee.ui.feature.cookie

import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.coffiiee.R
import com.example.coffiiee.navigation.LocalNavController
import com.example.coffiiee.navigation.Routes
import com.example.coffiiee.ui.feature.CookeiDetails.AppBar
import com.example.coffiiee.ui.theme.urbaniFamily
import kotlin.math.absoluteValue
import kotlin.math.pow

@Composable
fun CookieSemiCircleCarousel() {
    Column(
        Modifier.background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        AppBar()
        Text(
            "Take your snack",
            fontSize = 22.sp,
            fontWeight = FontWeight.W700,
            fontFamily = urbaniFamily,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center,
            letterSpacing = 0.25.sp,
            modifier = Modifier.padding(16.dp)
        )
        val navController = LocalNavController.current
        val items = listOf(
            R.drawable.chocolate,
            R.drawable.cupcake,
            R.drawable.cookies,
            R.drawable.cake,
            R.drawable.crwason,
            R.drawable.oreo
        )
        val pagerState = rememberPagerState(initialPage = 3) { items.size }

        VerticalPager(
            state = pagerState,
            pageSpacing = (-350).dp,
            beyondViewportPageCount = 5,
            flingBehavior = PagerDefaults.flingBehavior(
                state = pagerState,
                snapPositionalThreshold = 0.2f,
                snapAnimationSpec = tween(
                    durationMillis = 600,
                    easing = EaseOut
                )
            ), modifier = Modifier.offset(y = 40.dp)
        ) { page ->
            val pageOffsetFraction =
                (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

            val transformations = Transformations(pageOffsetFraction)

            Card(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color(0x0000001F))
                    .clip(MaterialTheme.shapes.medium)
                    .scale(transformations.scale)
                    .rotate(transformations.rotate)
                    .offset(x = transformations.offsetX.dp, y = transformations.offsetY.dp)
                    .clickable { navController.navigate(Routes.CookeiDetealis(items[page])) }
                  ,
                colors = CardDefaults.cardColors(Color(0x0000001F))
            ) {
                Image(
                    painter = painterResource(items[page]),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

private data class PageTransformations(
    val rotate: Float,
    val offsetX: Float,
    val offsetY: Float,
    val scale: Float
)

private fun Transformations(pageOffsetFraction: Float): PageTransformations {
    val absOffset = pageOffsetFraction.absoluteValue
    val clampedOffset = pageOffsetFraction.coerceIn(-1f, 1f)
    val clampedAbsOffset = absOffset.coerceIn(-1f, 1f)

    val rotate = lerp(
        start = if (pageOffsetFraction != 0f) -8f else 0f,
        stop = 0f,
        fraction = 1f - pageOffsetFraction.coerceIn(-2f, 1f)
    )

    val offsetX = lerp(
        start = when {
            pageOffsetFraction < 0f -> -(absOffset.pow(2) * 50f)
            pageOffsetFraction > 0f -> -(absOffset.pow(2) * 50f)
            else -> -24f
        },
        stop = -32f,
        fraction = 1f - clampedAbsOffset
    )

    val offsetY = lerp(
        start = absOffset.pow(2) * 40f,
        stop = 0f,
        fraction = 1f - clampedAbsOffset
    )

    val scale = lerp(
        start = 0.75f,
        stop = 1f,
        fraction = 1f - clampedOffset
    )

    return PageTransformations(rotate, offsetX, offsetY, scale)
}
