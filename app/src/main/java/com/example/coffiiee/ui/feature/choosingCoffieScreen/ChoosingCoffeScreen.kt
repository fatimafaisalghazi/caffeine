package com.example.coffiiee.ui.feature.choosingCoffieScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coffiiee.R
import com.example.coffiiee.navigation.LocalNavController
import com.example.coffiiee.navigation.Routes
import com.example.coffiiee.ui.component.ButtonSection
import com.example.coffiiee.ui.component.HomeScreenAppBar
import com.example.coffiiee.ui.component.WelcomeMessageText

@Composable
fun ChoosingCoffeeScreen() {

    val navController = LocalNavController.current
    val pagerState: PagerState = rememberPagerState(3) { 4 }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        item {
            HomeScreenAppBar()
            WelcomeMessage(Modifier.padding(top = 8.dp))
        }
        item {
            Spacer(Modifier.height(44.dp))
        }
        item {
            CoffeeCup(
                pagerState = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        }
        item {
            ButtonSection(
                text = "Continue",
                icon = painterResource(R.drawable.icon_right_arrow),
                onClick = {
                    navController.navigate(
                        Routes.CustomizeCoffeeScreen(index = pagerState.currentPage)
                    )
                }
            )
        }
    }
}


@Composable
private fun WelcomeMessage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
    ) {
        WelcomeMessageText(text = "Good Morning", textSize = 36, color = Color(0xFFB3B3B3))
        WelcomeMessageText(text = "Hamsa ☀", textSize = 36, color = Color(0xFF3B3B3B))
        WelcomeMessageText(
            text = "What would you like to drink today?", textSize = 16,
            color = Color(0xCC1F1F1F)
        )
    }
}


