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
    data object LoadingScreen :Routes
}

//sealed interface Route {
//
//    @Serializable
//    data object OnboardingScreen : Route
//
//    @Serializable
//    data object HomeScreen : Route
//
//    @Serializable
//    data class TasksScreen(
//        val taskState: Task.State = Task.State.IN_PROGRESS,
//    ) : Route
//
//    @Serializable
//    data object CategoriesScreen : Route
//
//    @Serializable
//    data class CategoryTasksScreen(
//        val categoryId: Long = 0L,
//    ) : Route
//}