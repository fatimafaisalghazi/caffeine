package com.example.coffiiee.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.coffiiee.ui.feature.LoadingScreen.LoadingScreen
import com.example.coffiiee.ui.feature.customizeCoffe.CustomizeCoffee
import com.example.coffiiee.ui.feature.choosingCoffieScreen.ChoosingCoffeeScreen
import com.example.coffiiee.ui.feature.gohstScreen.HomeScreen


@Composable
fun CoffeeNavHost(
    navController: NavHostController,
    startDestination: Routes,
    modifier: Modifier = Modifier
) {
    CompositionLocalProvider(
        LocalNavController provides navController
    ) {
        NavHost(
            modifier = modifier,
            startDestination = startDestination,
            navController = navController
        ) {
            composable<Routes.HomeScreen> {
                HomeScreen()
            }
            composable<Routes.ChoosingCoffeeScreen> {
                ChoosingCoffeeScreen()
            }
            composable<Routes.CustomizeCoffeeScreen> {
                val index = it.toRoute<Routes.CustomizeCoffeeScreen>().index
                CustomizeCoffee(index)
            }
            composable<Routes.LoadingScreen> {
                LoadingScreen()
            }
        }
    }
}

val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("No NavigationController provided")
}