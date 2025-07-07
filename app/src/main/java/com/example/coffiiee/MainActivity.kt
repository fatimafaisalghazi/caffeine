package com.example.coffiiee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.coffiiee.ui.feature.choosingCoffieScreen.ChoosingCoffeeScreen
import com.example.coffiiee.ui.feature.gohstScreen.HomeScreen
import com.example.coffiiee.navigation.CoffeeNavHost
import com.example.coffiiee.navigation.LocalNavController
import com.example.coffiiee.navigation.Routes
import com.example.coffiiee.ui.feature.customizeCoffe.CustomizeCoffee
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

                val navController = rememberNavController()
                CoffeeNavHost(
                    navController,
                    startDestination = Routes.HomeScreen,
                )
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