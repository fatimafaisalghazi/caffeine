package com.example.coffiiee.ui.feature.closingCup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.coffiiee.R
import com.example.coffiiee.navigation.LocalNavController
import com.example.coffiiee.navigation.Routes
import com.example.coffiiee.ui.component.ButtonSection
import com.example.coffiiee.ui.feature.cookeiDetealis.AppBar
import com.example.coffiiee.ui.theme.urbaniFamily

@Composable
fun ClosingCupScreen(
    modifier: Modifier = Modifier
) {
    val navController = LocalNavController.current

//    LazyColumn(
//        modifier = Modifier.fillMaxSize().background(Color.White),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top,
//    ) {
//        item {
    val scroll = rememberScrollState()
            Box(Modifier.fillMaxWidth()
                , contentAlignment = Alignment.Center) {
                Column(
                    Modifier.fillMaxWidth().verticalScroll(scroll)
                       ,
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AnimatedAppBar()
                    EnjoyMessage()
                    CupWithLid()
                    Column(verticalArrangement = Arrangement.Bottom
                    ) {
                        PrepareToTakeAway(Modifier.padding(vertical = 16.dp))

                        ButtonSection(
                            text = "Take snack",
                            icon = painterResource(R.drawable.arrow_right),
                            onClick = { navController.navigate(Routes.CookieSemiCircleCarousel) },
                            Modifier
                                .padding(top = 32.dp)
                        )
                    }
                }

            }
        }
//        item {
//            Box(contentAlignment = Alignment.Center) {
//
//            }
//        }
//    }
//}


@Composable
fun EnjoyMessage(modifier: Modifier = Modifier) {
    var lidVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        lidVisible = true
    }
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp

    AnimatedVisibility(
        visible = lidVisible,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> -screenHeightDp },
            animationSpec = tween(durationMillis = 700)
        ),
        exit = ExitTransition.None
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFF7C351B),
                            shape = RoundedCornerShape(50)
                        )
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        tint = Color(0xDEFFFFFF),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Your coffee is ready, Enjoy",
                        fontFamily = urbaniFamily,
                        fontWeight = FontWeight.W700,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        maxLines = 3,
                        softWrap = true,
                        modifier = Modifier
                            .fillMaxWidth(0.8f),
                        letterSpacing = 0.25.em
                    )
                }
            }
        }
    }
}


@Composable
fun PrepareToTakeAway(modifier: Modifier = Modifier) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CoffeeButton(onClick = {})
        Text(
            "Take Away",
            fontFamily = urbaniFamily,
            fontWeight = FontWeight.W700,
            fontSize = 14.sp,
            letterSpacing = 0.25.em,
            color = Color(0xFF626262)
        )
    }
}
