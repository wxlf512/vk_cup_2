package dev.wxlf.vk_cup_2.presentation.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import dev.wxlf.vk_cup_2.presentation.elements.draganddrop.DragTarget
import dev.wxlf.vk_cup_2.presentation.elements.draganddrop.Draggable
import dev.wxlf.vk_cup_2.presentation.elements.draganddrop.DropTarget

@Composable
fun TextWithGapsDrag(
    modifier: Modifier = Modifier,
    phrase: List<String>,
    correctWords: List<String>,
    allWords: MutableMap<String, Boolean>,
    firstInput: Boolean,
    textSize: TextUnit = 16.sp
) {
    val allWordsCopy = remember { mutableStateMapOf<String, Boolean>() }
    LaunchedEffect(key1 = Unit, block = {
        allWordsCopy.putAll(allWords)
    })
    Draggable(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = modifier) {
            FlowRow(
                crossAxisAlignment = FlowCrossAxisAlignment.Center,
                mainAxisSpacing = 8.dp,
                crossAxisSpacing = 2.dp
            ) {
                if (firstInput) {
                    val word = remember { mutableStateOf("") }
                    DropTarget<String> { isInBound, data ->
                        var bgColor = if (word.value == correctWords[0] && !isInBound) {
                            Color(0xFF4CC76A)
                        } else if (word.value != correctWords[0] && word.value.isNotEmpty()) {
                            Color(0xFFB94B4B)
                        } else MaterialTheme.colorScheme.tertiary

                        bgColor = if (isInBound) MaterialTheme.colorScheme.secondary else bgColor

                        data?.let {
                            if (isInBound) {
                                if (word.value in allWordsCopy.keys)
                                    allWordsCopy[word.value] = true
                                word.value = data
                                allWordsCopy[data] = false
                            }
                        }

                        Box(
                            Modifier
                                .size(height = 32.dp, width = 96.dp)
                                .background(bgColor, CircleShape)
                                .clickable {
                                    if (word.value in allWordsCopy.keys)
                                        allWordsCopy[word.value] = true
                                    word.value = ""
                                }) {
                            Text(
                                word.value,
                                modifier = Modifier.align(Alignment.Center),
                                color = MaterialTheme.colorScheme.onTertiary
                            )
                        }
                    }
                }
                phrase.forEachIndexed { index, s ->
                    s.split(" ").forEach {
                        Text(it, fontSize = textSize)
                    }
                    if (firstInput) {
                        if (index + 1 in 0..correctWords.lastIndex) {
                            val word = remember { mutableStateOf("") }
                            DropTarget<String> { isInBound, data ->
                                var bgColor = if (word.value == correctWords[index + 1] && !isInBound) {
                                    Color(0xFF4CC76A)
                                } else if (word.value != correctWords[index + 1] && word.value.isNotEmpty()) {
                                    Color(0xFFB94B4B)
                                } else MaterialTheme.colorScheme.tertiary

                                bgColor = if (isInBound) MaterialTheme.colorScheme.secondary else bgColor

                                data?.let {
                                    if (isInBound) {
                                        if (word.value in allWordsCopy.keys)
                                            allWordsCopy[word.value] = true
                                        word.value = data
                                        allWordsCopy[data] = false
                                    }
                                }

                                Box(
                                    Modifier
                                        .size(height = 32.dp, width = 96.dp)
                                        .background(bgColor, CircleShape)
                                        .clickable {
                                            if (word.value in allWordsCopy.keys)
                                                allWordsCopy[word.value] = true
                                            word.value = ""
                                        }) {
                                    Text(
                                        word.value,
                                        modifier = Modifier.align(Alignment.Center),
                                        color = MaterialTheme.colorScheme.onTertiary
                                    )
                                }
                            }
                        }
                    } else
                        if (index in 0..correctWords.lastIndex) {
                            val word = remember { mutableStateOf("") }
                            DropTarget<String> { isInBound, data ->
                                var bgColor = if (word.value == correctWords[index] && !isInBound) {
                                    Color(0xFF4CC76A)
                                } else if (word.value != correctWords[index] && word.value.isNotEmpty()) {
                                    Color(0xFFB94B4B)
                                } else MaterialTheme.colorScheme.tertiary

                                bgColor = if (isInBound) MaterialTheme.colorScheme.secondary else bgColor

                                data?.let {
                                    if (isInBound) {
                                        if (word.value in allWordsCopy.keys)
                                            allWordsCopy[word.value] = true
                                        word.value = data
                                        allWordsCopy[data] = false
                                    }
                                }

                                Box(
                                    Modifier
                                        .size(height = 32.dp, width = 96.dp)
                                        .background(bgColor, CircleShape)
                                        .clickable {
                                            if (word.value in allWordsCopy.keys)
                                                allWordsCopy[word.value] = true
                                            word.value = ""
                                        }) {
                                    Text(
                                        word.value,
                                        modifier = Modifier.align(Alignment.Center),
                                        color = MaterialTheme.colorScheme.onTertiary
                                    )
                                }
                            }
                        }
                }
            }
            FlowRow(
                mainAxisAlignment = FlowMainAxisAlignment.Center,
                crossAxisAlignment = FlowCrossAxisAlignment.Center,
                mainAxisSpacing = 8.dp,
                crossAxisSpacing = 2.dp,
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
            ) {
                allWordsCopy.forEach { (word, active) ->
                    DragTarget(dataToDrop = word, enabled = active) {
                        OutlinedButton(onClick = {}, enabled = active) {
                            Text(word)
                        }
                    }
                }
            }
        }
    }
}