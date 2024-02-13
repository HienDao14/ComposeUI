package com.example.composelearn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelearn.data.Card
import com.example.composelearn.ui.theme.BlueEnd
import com.example.composelearn.ui.theme.BlueStart
import com.example.composelearn.ui.theme.GreenEnd
import com.example.composelearn.ui.theme.GreenStart
import com.example.composelearn.ui.theme.OrangeEnd
import com.example.composelearn.ui.theme.OrangeStart
import com.example.composelearn.ui.theme.PurpleEnd
import com.example.composelearn.ui.theme.PurpleStart

@Preview
@Composable
fun CardSection() {
    LazyRow(
        modifier = Modifier
    ) {
        items(cards.size) { index ->
            CardItem(index)
        }

    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var firstItemPadding = 0.dp
    if (index == 0) {
        firstItemPadding = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") image = painterResource(id = R.drawable.ic_mastercard)

    Box(modifier = Modifier.padding(start = firstItemPadding, end = 16.dp)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween) {

            Image(
                painter = image,
                contentDescription = card.cardType,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

val cards = listOf(
    Card("Visa", "996 343 765 600", "HienDao", 1000000.0, getGradient(PurpleStart, PurpleEnd)),
    Card("MASTER CARD", "123 456 789 001", "Home", 11230.0, getGradient(OrangeStart, OrangeEnd)),
    Card("Visa", "897 1345 123 097", "School", 5312.0, getGradient(GreenStart, GreenEnd)),
    Card("MASTER CARD", "888 888 888 8888", "Entertain", 88888.8, getGradient(BlueStart, BlueEnd))
)

fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}