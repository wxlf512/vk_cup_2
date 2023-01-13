package dev.wxlf.vk_cup_2.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.wxlf.vk_cup_2.presentation.elements.MatchThePairs

@Composable
fun MatchThePairsScreen() {
    var itemsListState by remember { mutableStateOf(10) }
    val lazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxSize(),
    ) {
        items(itemsListState) {
            MatchThePairs(
                modifier = Modifier.padding(16.dp),
                pairs = mapOf(
                    "один" to "1",
                    "два" to "2",
                    "три" to "3",
                    "четыре" to "4"
                )
            )
            Divider()

            if (it == itemsListState - 2) {
                itemsListState += itemsListState
            }
        }
    }
}