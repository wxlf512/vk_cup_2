package dev.wxlf.vk_cup_2.presentation.elements

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Quiz(modifier: Modifier = Modifier, questions: List<QuizModel>) {
    val pagerState = rememberPagerState()
    val pagerScope = rememberCoroutineScope()

    HorizontalPager(
        modifier = modifier,
        pageCount = questions.size,
        state = pagerState,
        userScrollEnabled = false
    ) {
        val quiz = questions[it]
        var answered by remember { mutableStateOf(false) }
        var userAnswer by remember { mutableStateOf(-1) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 42.dp)
        ) {
            Text("Вопрос ${it + 1}/${questions.size}")
            Text(
                quiz.question,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            quiz.answers.forEachIndexed { index, answerModel ->
                if (!answered) {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth()
                            .background(
                                MaterialTheme.colorScheme.tertiary,
                                RoundedCornerShape(5.dp)
                            )
                            .clickable {
                                answered = true
                                userAnswer = index
                            }
                            .padding(horizontal = 16.dp, vertical = 16.dp)
                    ) {
                        Text(answerModel.answer, color = MaterialTheme.colorScheme.onTertiary)
                    }

                } else if (userAnswer != quiz.rightAnswer) {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth()
                            .background(
                                when (index) {
                                    quiz.rightAnswer -> Color(0xFF4CC76A)
                                    userAnswer -> Color(0xFFB94B4B)
                                    else -> MaterialTheme.colorScheme.tertiary
                                },
                                RoundedCornerShape(5.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 16.dp)
                    ) {
                        Text(
                            answerModel.answer,
                            modifier = Modifier.align(Alignment.CenterStart),
                            color = MaterialTheme.colorScheme.onTertiary
                        )
                        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                            if (index == quiz.rightAnswer)
                                Icon(
                                    Icons.Default.Done,
                                    contentDescription = "Right answer",
                                    tint = Color.Green
                                )
                            else if (index == userAnswer)
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = "Wrong answer",
                                    tint = Color.Red
                                )
                            Text(
                                "${answerModel.percentages}%",
                                modifier = Modifier.padding(start = 8.dp)
                            )

                        }
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth()
                            .background(
                                if (index == quiz.rightAnswer) Color(0xFF4CC76A)
                                else Color(0xFF607E80),
                                RoundedCornerShape(5.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 16.dp)
                    ) {
                        Text(answerModel.answer, modifier = Modifier.align(Alignment.CenterStart))
                        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                            if (index == quiz.rightAnswer)
                                Icon(
                                    Icons.Default.Done,
                                    contentDescription = "Right answer",
                                    tint = Color.Green
                                )
                            Text(
                                "${answerModel.percentages}%",
                                modifier = Modifier.padding(start = 8.dp)
                            )

                        }
                    }
                }
            }
            if (answered && pagerState.canScrollForward) {
                Button(onClick = {
                    pagerScope.launch {
                        pagerState.scrollToPage(it + 1)
                    }
                }, modifier = Modifier.align(Alignment.End)) {
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Next")
                }
            }
        }
    }

}
