package com.example.composelearn

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelearn.data.Finance
import com.example.composelearn.ui.theme.BlueStart
import com.example.composelearn.ui.theme.GreenStart
import com.example.composelearn.ui.theme.OrangeStart
import com.example.composelearn.ui.theme.PurpleStart

@Preview
@Composable
fun FinanceSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Finance", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow {
            items(finances.size) { index ->
                FinanceItem(index)
            }
        }
    }
}

@Composable
fun FinanceItem(index: Int) {
    val finance = finances[index]
    var firstItemMargin = 0.dp
    if (index == 0) {
        firstItemMargin = 16.dp
    }
    Box(
        modifier = Modifier
            .padding(start = firstItemMargin, end = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable { }
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.iconBackground)
                    .padding(6.dp)

            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = finance.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

val finances = listOf(
    Finance(Icons.Rounded.Star, "My\nBusiness", OrangeStart),
    Finance(Icons.Rounded.Wallet, "My\nWallet", BlueStart),
    Finance(Icons.Rounded.Analytics, "Finance\nAnalytics", PurpleStart),
    Finance(Icons.Rounded.MonetizationOn, "My\nTransactions", GreenStart),
)