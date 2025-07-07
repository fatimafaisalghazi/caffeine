package com.example.coffiiee.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffiiee.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoffeeViewModel : ViewModel() {

    private val _state = MutableStateFlow(CoffeeUiState())
    val state = _state.asStateFlow()

    fun setSelectedCoffee(coffee: String) {
        _state.update { it.copy(selectedCoffee = coffee) }
    }

    fun dropCoffee(name: String) {
        viewModelScope.launch {
            val coffeeResId = when (name) {
                "s" -> R.drawable.defaultdrop
                "l" -> R.drawable.droppping
                else -> R.drawable.defaultdrop
            }

            _state.update { it.copy(droppedCoffee = coffeeResId, buttonName = name) }

            delay(800)
            _state.update { it.copy(droppedCoffee = -1) }
        }
    }

    fun selectButton(nameOfButton: String) {
        _state.update { it.copy(buttonName = nameOfButton) }
    }
}
