package dev.wxlf.vk_cup_2.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.wxlf.vk_cup_2.R
import dev.wxlf.vk_cup_2.presentation.elements.RatingBar
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun RatingBarScreen() {
    var itemsListState by remember { mutableStateOf(25) }
    val lazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxSize(),
    ) {
        items(itemsListState) {
            val rating = remember {
                mutableStateOf(Random.nextInt(1..5))
            }
            RatingBar(
                rating = rating,
                starEmpty = R.drawable.star_empty,
                starFull = R.drawable.star_full,
                starTint = Color(0xFFF97224),
                modifier = Modifier.padding(16.dp)
            )
            Divider()

            if (it == itemsListState - 2) {
                itemsListState += itemsListState
            }
        }
    }
}