package com.example.coffiiee.ui.feature.customizeCoffe

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coffiiee.R
import com.example.coffiiee.component.CircleButton
import com.example.coffiiee.component.CustomizeButtonBackground
import com.example.coffiiee.viewModel.CoffeeViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun DroppingCoffeeButtons(
    viewModel: CoffeeViewModel = koinViewModel()
) {
    val shadow = animateDpAsState(targetValue =  8.dp )

    CustomizeButtonBackground{
        CircleButton(
            onClick = { viewModel.dropCoffee("s") },
            color = Color.DarkGray,
            shadow = shadow
        ) {
            IconButton()
        }
        CircleButton(
            onClick = {
                viewModel.dropCoffee("l")
            },
            shadow = shadow,
            color = Color.DarkGray
        ) {
            IconButton()
        }
        CircleButton(
            onClick = { viewModel.dropCoffee("s") },
            color = Color.DarkGray,
            shadow =  shadow
        ) {
            IconButton()
        }
    }
}

@Composable
private fun IconButton(modifier: Modifier = Modifier) {
    Icon(painter = painterResource(R.drawable.coffe_ic), contentDescription = null)

}