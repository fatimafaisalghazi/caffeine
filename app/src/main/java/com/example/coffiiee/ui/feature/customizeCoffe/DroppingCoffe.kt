package com.example.coffiiee.ui.feature.customizeCoffe


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffiiee.R
import com.example.coffiiee.ui.component.CircleButton
import com.example.coffiiee.ui.component.CustomizeButtonBackground
import com.example.coffiiee.ui.theme.urbaniFamily
import kotlinx.coroutines.delay


@Composable
fun DroppingCoffeeButtons() {

    val buttonCount = 3
    var selectedIndex by remember { mutableStateOf(0) }

    val dropOffsets = List(buttonCount) { index ->
        animateDpAsState(
            targetValue = if (selectedIndex == index) -400.dp else (-500).dp,
            animationSpec = tween(700)
        )
    }
    val alphaAnims = List(buttonCount) { index ->
        animateFloatAsState(
            targetValue = if (selectedIndex == index) 1f else 0f,
            animationSpec = tween(300)
        )
    }
    Box(modifier = Modifier.height(150.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            for (i in 0 until buttonCount) {
                Image(
                    painter = painterResource(R.drawable.defaultdrop),
                    contentDescription = "Drop $i",
                    modifier = Modifier
                        .offset(y = dropOffsets[i].value)
                        .size(120.dp)
                        .graphicsLayer {
                            alpha = alphaAnims[i].value
                            transformOrigin = TransformOrigin(0.5f, 1f)
                        }
                        .align(Alignment.TopCenter)
                )
            }
        }

        Column(
            modifier = Modifier.align(Alignment.TopCenter), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top
        ) {
            CustomizeButtonBackground(Modifier.padding(vertical = 8.dp, horizontal = 8.dp)) {
                for (i in 0 until buttonCount) {

                    val color = animateColorAsState(
                        targetValue = if (selectedIndex != i) Color(0xFFF5F5F5) else Color(
                            0xFF7C351B
                        ), tween(200)
                    )
                    val IconColor = animateColorAsState(
                        if (selectedIndex != i) Color(0xFFF5F5F5) else Color.White,
                        tween(200)
                    )
                    val shadow = animateDpAsState(
                        targetValue = if (selectedIndex == i) 8.dp else 0.dp,
                        animationSpec = tween(0)
                    )

                    CircleButton(
                        onClick = {
                            selectedIndex = if (selectedIndex == i) -1 else i
                        },
                        color = color.value,
                        shadow = shadow,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        if (selectedIndex == i)
                            EmptyIcon(tint = IconColor.value)
                        else
                            IconButton(tint = IconColor.value)
                    }
                }
            }
            StatusTextSection()
        }
    }
}


@Composable
private fun IconButton(tint: Color, modifier: Modifier = Modifier) {
    Icon(painter = painterResource(R.drawable.coffe_ic), contentDescription = null,
        tint = tint, modifier = Modifier.size(24.dp))
}

@Composable
private fun EmptyIcon(tint: Color, modifier: Modifier = Modifier) {
    Icon(painter = painterResource(R.drawable.coffe_ic), contentDescription = null, tint = tint,
        modifier = Modifier.size(24.dp))
}

@Composable
fun StatusTextSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        StatusText("Low")
        Spacer(modifier = Modifier.width(18.dp))
        StatusText("Medium")
        Spacer(modifier = Modifier.width(18.dp))
        StatusText("High")
    }
}

@Composable
fun StatusText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 10.sp,
        fontWeight = FontWeight.W500,
        fontFamily = urbaniFamily,
        lineHeight = 50.sp,
        textAlign = TextAlign.Center,
        letterSpacing = 0.25.sp,
        color = Color(0x991F1F1F)
    )
}