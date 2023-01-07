package dev.wxlf.vk_cup_2.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import dev.wxlf.vk_cup_2.R
import dev.wxlf.vk_cup_2.presentation.elements.*
import dev.wxlf.vk_cup_2.presentation.theme.Vk_cup_2Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Vk_cup_2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Quiz(
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
                        val rating = remember {
                            mutableStateOf(3)
                        }
                        RatingBar(
                            rating = rating,
                            starEmpty = R.drawable.star_empty,
                            starFull = R.drawable.star_full,
                            starTint = Color(0xFFF97224),
                            modifier = Modifier.padding(start = 42.dp, top = 16.dp)
                        )
                        MatchThePairs(modifier = Modifier.padding(32.dp), pairs = mapOf("один" to "1", "два" to "2", "три" to "3", "четыре" to "4"))
                    }
                }
            }
        }
    }
}

