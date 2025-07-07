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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.rememberNavController
import com.example.coffiiee.HomeScreenAppBar
import com.example.coffiiee.R
import com.example.coffiiee.component.ActionButton
import com.example.coffiiee.component.ButtonText
import com.example.coffiiee.component.WelcomeMessageText
import com.example.coffiiee.navigation.LocalNavController
import com.example.coffiiee.navigation.Routes
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
        ButtonSection(onClick = { navController.navigate(route = Routes.ChoosingCoffeeScreen) })
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
    val opesitStar by infiniteTransition.animateColor(
        initialValue = Color.LightGray,
        targetValue = Color.DarkGray,
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
                tint = opesitStar
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
        initialValue = 50.dp,
        typeConverter = Dp.VectorConverter,
        label = "animate the offset of the ghost"
    )
    val shadow by infiniteTransition.animateValue(
        targetValue = -50.dp,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(700),
            repeatMode = RepeatMode.Reverse,
        ),
        initialValue = 34.dp,
        typeConverter = Dp.VectorConverter,
        label = "animate the offset of the shadow"
    )
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.ghost),
            contentDescription = null,
            modifier = Modifier
                .size(244.dp)
                .offset(y = scale),
        )
    }
    Box(
        contentAlignment = Alignment.Center,
    ) {
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

@Composable
private fun ButtonSection(
    onClick: () -> Unit, modifier: Modifier = Modifier
) {
    ActionButton(onClick = { onClick() }
    ) {
        ButtonText(text = "bring my coffee")
        Icon(
            painter = painterResource(R.drawable.ic_coffie),
            contentDescription = null,
            Modifier.size(24.dp)
        )
    }
}