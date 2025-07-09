package com.example.coffiiee.ui.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.coffiiee.navigation.CoffeeNavHost
import com.example.coffiiee.navigation.Routes
import com.example.coffiiee.ui.theme.CoffiieeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffiieeTheme {
                val navController = rememberNavController()

                CoffeeNavHost(
                    navController,
                    startDestination = Routes.HomeScreen,
                )
            }
        }
    }
}
