package dev.wxlf.vk_cup_2.presentation.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: MutableState<Int>,
    maxRating: Int = 5,
    spacing: Dp = 4.dp,
    starFull: Int,
    starEmpty: Int,
    starTint: Color
) {
//    val rates = remember { mutableStateListOf<Boolean>() }
    val rates = mutableListOf<Boolean>()
    for (i in 0 until rating.value)
        rates.add(true)
    for (i in rating.value + 1..maxRating)
        rates.add(false)
    Row(modifier = modifier) {
        rates.forEachIndexed { index, it ->
            Icon(
                painter = painterResource(id = if (it) starFull else starEmpty),
                contentDescription = "Star",
                tint = starTint,
                modifier = Modifier.padding(end = spacing).clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() } // This is mandatory
                ) {
                    rating.value = index + 1
                }
            )
        }
    }
}