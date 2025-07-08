package com.example.coffiiee.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.coffiiee.navigation.CoffeeNavHost
import com.example.coffiiee.navigation.Routes
import com.example.coffiiee.ui.feature.LoadingScreen.LoadingScreen
import com.example.coffiiee.ui.feature.closingCup.ClosingCupScreen
import com.example.coffiiee.ui.feature.closingCup.CupWithLid
import com.example.coffiiee.ui.feature.cockes.CookieSemiCircleCarousel
import com.example.coffiiee.ui.theme.CoffiieeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffiieeTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                Column(Modifier.background(Color.DarkGray)) {
//                    HomeScreenAppBar(Modifier.padding(vertical = 20.dp))
//
//                }
//                }

//                HomeScreen()
//                ChoosingCoffeeScreen()
//                CustomizeCoffee()
//                ClosingCupScreen()

//                val navController = rememberNavController()
//                CoffeeNavHost(
//                    navController,
//                    startDestination = Routes.HomeScreen,
//                )

//                CookieSemiCircleCarousel()
                ClosingCupScreen()
//                CookieSemiCircleCarousel()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoffiieeTheme {
    }
}