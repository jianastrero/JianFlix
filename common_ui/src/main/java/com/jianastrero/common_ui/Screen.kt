package com.jianastrero.common_ui

sealed class Screen(val route: String) {

    object MovieMainListScreen : Screen("movie_main_list")
    object MovieDetailScreen : Screen("movie_detail")

}