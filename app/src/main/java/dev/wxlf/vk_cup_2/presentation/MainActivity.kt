package dev.wxlf.vk_cup_2.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.wxlf.vk_cup_2.common.Routes
import dev.wxlf.vk_cup_2.presentation.screens.*
import dev.wxlf.vk_cup_2.presentation.theme.Vk_cup_2Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Vk_cup_2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Routes.Main.route
                    ) {
                        composable(Routes.Main.route) { MainScreen(navController = navController) }
                        composable(Routes.Quiz.route) { QuizScreen() }
                        composable(Routes.MatchThePairs.route) { MatchThePairsScreen() }
                        composable(Routes.TextWithGapsDrag.route) { TextWithGapsDragScreen() }
                        composable(Routes.TextWithGaps.route) { TextWithGapsScreen() }
                        composable(Routes.RatingBar.route) { RatingBarScreen() }
                    }
                }
            }
        }
    }
}

