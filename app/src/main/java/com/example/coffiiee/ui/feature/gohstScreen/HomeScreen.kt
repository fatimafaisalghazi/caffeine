package com.example.coffiiee.ui.feature.gohstScreen


import androidx.compose.animation.animateColor
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.coffiiee.ui.component.HomeScreenAppBar
import com.example.coffiiee.R
import com.example.coffiiee.ui.component.ActionButton
import com.example.coffiiee.ui.component.ButtonText
import com.example.coffiiee.navigation.LocalNavController
import com.example.coffiiee.navigation.Routes
import com.example.coffiiee.ui.component.ButtonSection
import com.example.coffiiee.ui.theme.urbaniFamily

@Composable
fun HomeScreen() {
    val navController = LocalNavController.current
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        HomeScreenAppBar()
        WelcomeMessage()
        FlyingGhost()
        ButtonSection(text = "bring my coffee", icon = painterResource(R.drawable.ic_coffie),
            onClick = { navController.navigate(route = Routes.ChoosingCoffeeScreen) })
    }
}


@Composable
private fun WelcomeMessage(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val stars by infiniteTransition.animateColor(
        initialValue = Color.DarkGray,
        targetValue = Color.LightGray,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(700),
            repeatMode = RepeatMode.Reverse,
        ),
    )

    Box(
        contentAlignment = Alignment.Center,
    ) {
        Box(
            Modifier
                .zIndex(1f)
                .offset(y = -90.dp, x = 90.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.glowing_star),
                contentDescription = null,
                Modifier.size(24.dp),
                tint = stars
            )
        }
        Box(
            Modifier
                .zIndex(1f)
                .offset(y = -30.dp, x = -78.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.glowing_star),
                contentDescription = null,
                Modifier.size(24.dp),
                tint = stars
            )
        }
        Box(
            Modifier
                .zIndex(1f)
                .offset(y = 100.dp, x = 78.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.glowing_star),
                contentDescription = null,
                Modifier.size(24.dp),
                tint = stars
            )
        }
        Text(
            "Hocus\n" +
                    "Pocus\n" +
                    "I Need Coffee\n" +
                    "to Focus",
            fontSize = 32.sp,
            fontWeight = FontWeight.W400,
            fontFamily = urbaniFamily,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
private fun FlyingGhost(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateValue(
        targetValue = 34.dp,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(700),
            repeatMode = RepeatMode.Reverse
        ),
        initialValue = 40.dp,
        typeConverter = Dp.VectorConverter,
        label = "animate the offset of the ghost"
    )
    val shadow by infiniteTransition.animateValue(
        targetValue = 40.dp,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(700),
            repeatMode = RepeatMode.Reverse,
        ),
        initialValue = 34.dp,
        typeConverter = Dp.VectorConverter,
        label = "animate the offset of the shadow"
    )
    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(R.drawable.ghost),
            contentDescription = null,
            modifier = Modifier
                .size(244.dp)
                .offset(y = scale),
        )
        Icon(
            painter = painterResource(R.drawable.ghost_shadow),
            contentDescription = null,
            modifier = Modifier
                .height(28.dp)
                .width(178.dp)
                .offset(y = shadow),
            tint = Color(0x1F1F1F24)
        )
    }
}
