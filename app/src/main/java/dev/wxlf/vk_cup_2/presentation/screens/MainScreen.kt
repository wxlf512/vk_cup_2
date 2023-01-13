package dev.wxlf.vk_cup_2.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.wxlf.vk_cup_2.common.Routes

@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { navController.navigate(Routes.Quiz.route) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Многоступенчатый опрос с вариантами ответов")
        }
        Button(
            onClick = { navController.navigate(Routes.MatchThePairs.route) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Сопоставление элементов между двумя столбцами")
        }
        Button(
            onClick = { navController.navigate(Routes.TextWithGapsDrag.route) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Перетаскивание вариантов в пропуски в тексте")
        }
        Button(
            onClick = { navController.navigate(Routes.TextWithGaps.route) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Заполнение пропусков в тексте")
        }
        Button(
            onClick = { navController.navigate(Routes.RatingBar.route) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Оценка прочитанной статьи")
        }
    }
}