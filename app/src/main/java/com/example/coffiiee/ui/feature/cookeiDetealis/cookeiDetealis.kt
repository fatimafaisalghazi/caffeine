package com.example.coffiiee.ui.feature.cookeiDetealis

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffiiee.R
import com.example.coffiiee.ui.component.ButtonSection
import com.example.coffiiee.ui.theme.snigletFamily

@Composable
fun CookeiDetealis(painter: Int) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        item {
            AppBar()
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.coffe_ic),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = Color(0xFF7C351B)
                )
                Text(
                    "More Espresso, Less Depresso",
                    fontWeight = FontWeight.W400,
                    fontSize = 20.sp,
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = snigletFamily,
                    color = Color(0xFF7C351B),
                )
                Icon(
                    painter = painterResource(id = R.drawable.coffe_ic),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = Color(0xFF7C351B)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = painter),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .size(300.dp)
                )
                Text(
                    text = "Bon appétit",
                    color = Color(0xDE1F1F1B),
                    fontWeight = FontWeight.W700,
                    fontSize = 20.sp,
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = snigletFamily,
                )

            }
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                ButtonSection(
                    text = "Thank youuu",
                    icon = painterResource(R.drawable.arrow_right),
                    onClick = {}
                )
            }
        }
    }
}