package com.example.coffiiee.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.coffiiee.ui.feature.CookeiDetails.CookeiDetails
import com.example.coffiiee.ui.feature.LoadingScreen.LoadingScreen
import com.example.coffiiee.ui.feature.choosingCoffieScreen.ChoosingCoffeeScreen
import com.example.coffiiee.ui.feature.closingCup.ClosingCupScreen
import com.example.coffiiee.ui.feature.cookie.CookieSemiCircleCarousel
import com.example.coffiiee.ui.feature.customizeCoffe.CustomizeCoffee
import com.example.coffiiee.ui.feature.ghostScreen.GhostScreen


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
                GhostScreen()
            }
            composable<Routes.ChoosingCoffeeScreen> {
                ChoosingCoffeeScreen()
            }
            composable<Routes.CustomizeCoffeeScreen> {
                val index = it.toRoute<Routes.CustomizeCoffeeScreen>().index
                CustomizeCoffee(index)
            }
            composable<Routes.LoadingScreen> {
                val res = it.toRoute<Routes.LoadingScreen>().res
                LoadingScreen(res)
            }
            composable<Routes.ClosingCupScreen> {
                ClosingCupScreen()
            }
            composable<Routes.CookieSemiCircleCarousel> {
                CookieSemiCircleCarousel()
            }
            composable<Routes.CookeiDetealis> {
                val res = it.toRoute<Routes.CookeiDetealis>().res
                CookeiDetails(res)
            }
        }
    }
}

val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("No NavigationController provided")
}