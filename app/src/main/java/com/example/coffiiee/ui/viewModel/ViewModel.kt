package com.example.coffiiee.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.coffiiee.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CupSizeViewModel:ViewModel() {
    private val _state = MutableStateFlow(UiState())
    val state =_state.asStateFlow()
    fun onButtonPressed(buttonName : String) {
        _state.update { currentState ->
            val newPainter = when(buttonName) {
                "small" -> R.drawable.small
                "med" -> R.drawable.med
                "large" -> R.drawable.large
                else -> R.drawable.small
            }

            currentState.copy(
                selectedButton = buttonName,
                painter = newPainter
            )
        }
    }
}
