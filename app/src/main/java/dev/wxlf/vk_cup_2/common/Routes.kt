package dev.wxlf.vk_cup_2.common

sealed class Routes(val route: String) {
    object Main : Routes("vk_cup_2://main")
    object Quiz : Routes("vk_cup_2://quiz")
    object MatchThePairs : Routes("vk_cup_2://match_the_pairs")
    object TextWithGapsDrag : Routes("vk_cup_2://text_with_gaps_drag")
    object TextWithGaps : Routes("vk_cup_2://text_with_gaps")
    object RatingBar : Routes("vk_cup_2://rating_bar")
}
