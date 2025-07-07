package com.example.coffiiee.ui.feature.LoadingScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.coffiiee.viewModel.CupSizeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoadingScreen(
    viewModel: CupSizeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(state.painter),
            contentDescription = null
        )
        Text(text = "Selected Button: ${state.selectedButton}")
    }
}