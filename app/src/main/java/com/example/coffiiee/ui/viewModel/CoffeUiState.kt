package com.example.coffiiee.ui.viewModel

data class CoffeeUiState(
    val droppedCoffee: Int = -1,
    val currentId: Int = 0,
    val buttonName: String = "med",
    val selectedCoffee: String = "Black Coffee"
)