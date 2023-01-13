package dev.wxlf.vk_cup_2.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.wxlf.vk_cup_2.presentation.elements.AnswerModel
import dev.wxlf.vk_cup_2.presentation.elements.Quiz
import dev.wxlf.vk_cup_2.presentation.elements.QuizModel

@Composable
fun QuizScreen() {
    var itemsListState by remember { mutableStateOf(10) }
    val lazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxSize(),
    ) {
        items(itemsListState) {
            Quiz(
                modifier = Modifier.padding(16.dp),
                questions = listOf(
                    QuizModel(
                        "Первый вопрос",
                        listOf(
                            AnswerModel("один", 100),
                            AnswerModel("два", 0),
                            AnswerModel("три", 0),
                            AnswerModel("четыре", 0)
                        ),
                        0
                    ),
                    QuizModel(
                        "Второй вопрос",
                        listOf(
                            AnswerModel("один", 100),
                            AnswerModel("два", 0),
                            AnswerModel("три", 0),
                            AnswerModel("четыре", 0)
                        ),
                        0
                    ),
                    QuizModel(
                        "Третий вопрос",
                        listOf(
                            AnswerModel("один", 100),
                            AnswerModel("два", 0),
                            AnswerModel("три", 0),
                            AnswerModel("четыре", 0)
                        ),
                        0
                    ),
                    QuizModel(
                        "Четвёртый вопрос",
                        listOf(
                            AnswerModel("один", 100),
                            AnswerModel("два", 0),
                            AnswerModel("три", 0),
                            AnswerModel("четыре", 0)
                        ),
                        0
                    ),
                )
            )
            Divider()

            if (it == itemsListState - 2) {
                itemsListState += itemsListState
            }
        }
    }
}