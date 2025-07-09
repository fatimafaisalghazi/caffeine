package com.example.coffiiee.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffiiee.R

@Composable
fun HomeScreenAppBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth().statusBarsPadding().padding(horizontal = 16.dp)

    ) {
        Image(
            painter = painterResource(R.drawable.image_of_ghost),
            contentDescription = null,
            modifier = Modifier.clip(RoundedCornerShape(50)).size(48.dp)
        )
        Box(
            modifier = Modifier
                .background(color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(50))
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painterResource(R.drawable.plus),
                tint = Color(0xDE1F1F1F),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
