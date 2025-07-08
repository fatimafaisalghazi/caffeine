package com.example.coffiiee.navigation

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object HomeScreen :Routes

    @Serializable
    data object ChoosingCoffeeScreen :Routes

    @Serializable
    data class CustomizeCoffeeScreen (
        val index:Int
    ):Routes

    @Serializable
    data class LoadingScreen (
        val res: Int
    ):Routes

    @Serializable
    data object ClosingCupScreen :Routes

    @Serializable
    data class CookeiDetealis (
        val res :Int
    ):Routes

    @Serializable
    data object CookieSemiCircleCarousel :Routes
}