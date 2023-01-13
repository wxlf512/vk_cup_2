package dev.wxlf.vk_cup_2.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.wxlf.vk_cup_2.presentation.elements.TextWithGapsDrag

@Composable
fun TextWithGapsDragScreen() {
    var itemsListState by remember { mutableStateOf(10) }
    val lazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxSize(),
    ) {
        items(itemsListState) {
            TextWithGapsDrag(
                modifier = Modifier.padding(16.dp),
                phrase = listOf("Текст", "несколькими пропусками", "вариантами"),
                correctWords = listOf("с", "и"),
                allWords = mutableMapOf("Один" to true, "Два" to true, "с" to true, "и" to true),
                firstInput = false,
                textSize = 18.sp
            )
            Divider()

            if (it == itemsListState - 2) {
                itemsListState += itemsListState
            }
        }
    }
}