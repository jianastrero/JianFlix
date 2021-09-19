package com.jianastrero.common_ui

/**
 * Create Screen for all screens for easier navigation
 *
 * @param route The route for the screen
 *
 * @author Jian James P. Astrero
 */
sealed class Screen(val route: String) {

    object MovieMainListScreen : Screen("movie_main_list")
    object MovieDetailScreen : Screen("movie_detail")

}