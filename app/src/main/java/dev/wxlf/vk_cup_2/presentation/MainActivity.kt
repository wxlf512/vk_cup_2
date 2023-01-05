package dev.wxlf.vk_cup_2.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import dev.wxlf.vk_cup_2.presentation.elements.AnswerModel
import dev.wxlf.vk_cup_2.presentation.elements.Quiz
import dev.wxlf.vk_cup_2.presentation.elements.QuizModel
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
                    Quiz(
                        listOf(
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
                }
            }
        }
    }
}

