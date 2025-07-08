package com.example.coffiiee.ui.feature.customizeCoffe

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.coffiiee.R
import com.example.coffiiee.navigation.LocalNavController
import com.example.coffiiee.navigation.Routes
import com.example.coffiiee.ui.component.ActionButton
import com.example.coffiiee.ui.component.ButtonSection
import com.example.coffiiee.ui.component.ButtonText
import com.example.coffiiee.ui.component.CustomizeButtonBackground
import com.example.coffiiee.ui.theme.urbaniFamily
import com.example.coffiiee.ui.viewModel.CoffeeViewModel
import com.example.coffiiee.ui.viewModel.CupSizeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CustomizeCoffee(
    index: Int,
    viewModel: CupSizeViewModel = koinViewModel()
) {
    val navController = LocalNavController.current

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        val typeOfCoffee = when (index) {
            0 -> "black"
            1 -> "late"
            2 -> "espresso"
            3 -> "macchiato"
            else -> "black"
        }
        CustomizeAppBar(typeOfCoffee = typeOfCoffee)
        CustomizeCup(viewModel = viewModel)
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomizeSizeButton(viewModel = viewModel)
            DroppingCoffeeButtons()
        }
        ButtonSection(
            text = "Continue", icon = painterResource(R.drawable.arrow_right),
            onClick = { navController.navigate(Routes.LoadingScreen) })
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CustomizeCup(
    modifier: Modifier = Modifier,
    dropCoffeeViewModel: CoffeeViewModel = koinViewModel(),
    viewModel: CupSizeViewModel,
) {
    Box(contentAlignment = Alignment.Center) {
        val state by viewModel.state.collectAsState()
        val coffeeState by dropCoffeeViewModel.state.collectAsState()

        AnimatedContent(
            targetState = coffeeState.droppedCoffee,
            transitionSpec = {
                ContentTransform(
                    targetContentEnter = slideInVertically(
                        initialOffsetY = { -it },
                        animationSpec = tween(800)
                    ) + scaleIn(
                        initialScale = 0.5f,
                        animationSpec = tween(800)
                    ) + fadeIn(
                        animationSpec = tween(800)
                    ),
                    initialContentExit = fadeOut(animationSpec = tween(300))
                )
            },
            label = ""
        ) { drinkResId ->
            if (drinkResId != -1) {
                Image(
                    painter = painterResource(drinkResId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center)
                        .offset(y = (-180).dp)
                        .zIndex(1f),
                    contentScale = ContentScale.Fit
                )
            }
        }
        AnimatedContent(
            targetState = state.painter,
            transitionSpec = {
                fadeIn(animationSpec = tween(500)) with fadeOut(animationSpec = tween(600))
            }
        ) { targetPainter ->
            Image(
                painter = painterResource(id = targetPainter),
                contentDescription = null,
                modifier = Modifier
                    .height(360.dp)
                    .zIndex(1f),
                contentScale = ContentScale.Fit
            )
        }
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.Center)
                .zIndex(1f)
        )
    }
}


@Composable
private fun CustomizeSizeButton(viewModel: CupSizeViewModel) {
    CustomizeButtonBackground(
        Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
    ) {
        ButtonAnimation(text = "S", buttonName = "small", viewModel = viewModel)
        ButtonAnimation(text = "M", buttonName = "med", viewModel = viewModel)
        ButtonAnimation(text = "L", buttonName = "large", viewModel = viewModel)
    }
}

@Composable
fun CustomizeAppBar(
    modifier: Modifier = Modifier,
    typeOfCoffee: String
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(50)
                )
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                tint = Color(0xDE1F1F1F),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = typeOfCoffee,
            fontFamily = urbaniFamily,
            fontWeight = FontWeight.W700,
            fontSize = 24.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}
