package com.example.coffiiee.ui.feature.cockes

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coffiiee.R
import com.example.coffiiee.navigation.LocalNavController
import com.example.coffiiee.navigation.Routes
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin

//@SuppressLint("UnusedBoxWithConstraintsScope")
//@Composable
//fun CookieSemiCircleCarousel() {
//    val items = listOf(
//        R.drawable.chocolate,
//        R.drawable.cupcake,
//        R.drawable.cookies,
//        R.drawable.cake,
//        R.drawable.crwason,
//        R.drawable.oreo
//    )
//
//    val pagerState = rememberPagerState(initialPage = 3) { items.size }
//
//    val radius = 500f // يتحكم بمدى انحناء القوس
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black),
//        contentAlignment = Alignment.CenterStart // ⬅️ القوس صار على اليسار
//    ) {
//        VerticalPager(
//            state = pagerState,
//            pageSpacing = (-750).dp // تقارب العناصر لرسم القوس (قيم سالبة للاقتراب)
//        ) { page ->
//
//            val pageOffset = (
//                    (pagerState.currentPage - page) +
//                            pagerState.currentPageOffsetFraction
//                    )
//
//            // تعديل الزاوية للحصول على انسيابية أفضل
//            val angleDegrees = pageOffset * 40f // تقليل الزاوية إلى 60 درجة لكل عنصر
//            val angleRadians = Math.toRadians(angleDegrees.toDouble())
//
//            // تعديل نصف القطر لضبط شكل القوس
//            val radius = 500.dp.value // نصف القطر الأكبر لجعل القوس أوسع
//
//            // حساب موقع العنصر على القوس نصف الدائري (عمودي)
//            val offsetX = (sin(angleRadians) * radius).toFloat()
//            val offsetY = (cos(angleRadians) * radius).toFloat()
//
//            // تقليل الحجم حسب البعد
//            val scale = 1f - abs(pageOffset) * 0.2f
//
//            Box(modifier = Modifier.fillMaxSize()) {
//                Card(
//                    modifier = Modifier
//                        .size(200.dp)
//                        .graphicsLayer {
//                            translationX = offsetX
//                            translationY = offsetY
//                            scaleY = scale
//                            cameraDistance = 16f * density
//                            rotationZ = -pageOffset * 15f
//                        }
//                        .clip(MaterialTheme.shapes.medium)
//                        .clickable {
//                            // Action on click
//                        }
//                        .clipToBounds()
//                ) {
//                    Image(
//                        painter = painterResource(items[page]),
//                        contentDescription = null,
//                        modifier = Modifier.fillMaxSize()
//                    )
//                }
//            }
//        }
//    }
//}

@Composable
fun CookieSemiCircleCarousel() {
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
    val offset = -40f
    val offsetY = 40f

    VerticalPager(
        state = pagerState,
        pageSpacing = (-750).dp
    ) { page ->

        Card(
            modifier = Modifier
                .size(200.dp).clickable { navController.navigate(Routes.CookeiDetealis(items[page])) }
                .clip(MaterialTheme.shapes.medium).graphicsLayer {
//                    rotationX=offsetY
//                    rotationY=offset
                }
        )
        {
            Image(
                painter = painterResource(items[page]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
