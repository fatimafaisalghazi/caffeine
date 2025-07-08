package com.example.coffiiee.ui.feature.LoadingScreen

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffiiee.R
import com.example.coffiiee.navigation.LocalNavController
import com.example.coffiiee.navigation.Routes
import com.example.coffiiee.ui.viewModel.CupSizeViewModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoadingScreen(
    res :Int,
    viewModel: CupSizeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavController.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(color = Color.White)
    ) {
        Image(
            painter = painterResource(res),
            contentDescription = null
        )
        DraggableBoxWithSlider(navController)
        WaitingMessage()
    }
}


@Composable
fun DraggableBoxWithSlider(navController:NavController) {
    LaunchedEffect(Unit){
        delay(5000)
        navController.navigate(Routes.ClosingCupScreen)
    }
    val configuration = LocalConfiguration.current

    val boxWidth = 200.dp
    val offsetX by animateFloatAsState(
        targetValue = -boxWidth.value / 2,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "offsetAnimation"
    )

    Box(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.line_img),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .offset(x = offsetX.dp, y = 0.dp)
                .height(70.dp)
                .fillMaxWidth()
                .align(Alignment.CenterStart)
                .background(Color.White)
                .padding(16.dp)
        )
    }
}

@Composable
fun WaitingMessage(modifier: Modifier = Modifier) {
    Column {
        Text(
            "Almost Done",
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )
        Text(
            "Your coffee will be finish in",
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )
        Image(painterResource(R.drawable.waiting_message), contentDescription = null)
    }
}


