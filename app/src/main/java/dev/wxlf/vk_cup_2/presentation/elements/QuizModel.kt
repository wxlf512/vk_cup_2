package dev.wxlf.vk_cup_2.presentation.elements

data class QuizModel(
    val question: String,
    val answers: List<AnswerModel>,
    val rightAnswer: Int
)

data class AnswerModel(
    val answer: String,
    val percentages: Int
)
