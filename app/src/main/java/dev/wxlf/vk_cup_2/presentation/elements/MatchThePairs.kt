package dev.wxlf.vk_cup_2.presentation.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun MatchThePairs(modifier: Modifier = Modifier, pairs: Map<String, String>) {
    val left by remember { mutableStateOf(pairs.keys) }
    val right by remember { mutableStateOf(pairs.values) }
    val defaultColor = MaterialTheme.colorScheme.primary
    val colorsLeft = remember { mutableStateListOf<Color>() }
    val colorsRight = remember { mutableStateListOf<Color>() }
    val choosed = remember { mutableStateListOf<Int>() }
    var choosing by remember { mutableStateOf(false) }
    var choosingNum by remember { mutableStateOf(-1) }
    for (i in 0 until pairs.size) {
        colorsLeft.add(defaultColor)
        colorsRight.add(defaultColor)
        choosed.add(-1)
    }

    Row(modifier = modifier) {
        Column(
            modifier = Modifier.padding(end = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            left.forEachIndexed { index, it ->
                OutlinedButton(
                    onClick = {
                        if (!choosing || choosingNum == index) {
                            if (colorsLeft[index] == defaultColor) {
                                colorsLeft[index] = Color(
                                    Random.nextInt(0, 255),
                                    Random.nextInt(0, 255),
                                    Random.nextInt(0, 255),
                                    255
                                )
                                choosing = true
                                choosingNum = index
                            } else {
                                colorsRight[choosed[index]] = defaultColor
                                colorsLeft[index] = defaultColor
                                choosing = false
                                choosingNum = -1
                            }
                        }
                    },
                    border = BorderStroke(2.dp, colorsLeft[index])
                ) {
                    Text(it)
                }
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            right.forEachIndexed { index, it ->
                OutlinedButton(
                    onClick = {
                        if (choosing && colorsRight[index] == defaultColor) {
                            colorsRight[index] = colorsLeft[choosingNum]
                            choosed[choosingNum] = index
                            choosing = false
                            choosingNum = -1
                        }
                    },
                    border = BorderStroke(2.dp, colorsRight[index])
                ) {
                    Text(it)
                }
            }
        }
    }
}