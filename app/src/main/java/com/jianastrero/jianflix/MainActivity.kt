package com.jianastrero.jianflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jianastrero.common_ui.Screen
import com.jianastrero.core.util.log
import com.jianastrero.common_ui.ui.theme.JianFlixTheme
import com.jianastrero.constant.StateConstants
import com.jianastrero.movie_detail.MovieDetailScreen
import com.jianastrero.movie_main_list.MovieMainListScreen

/**
 * The main and only activity of the app
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JianFlixTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.MovieMainListScreen.route
                ) {
                    composable(route = Screen.MovieMainListScreen.route) {
                        MovieMainListScreen(navController = navController)
                    }
                    composable(
                        route = Screen.MovieDetailScreen.route + "/{${StateConstants.PARAM_MOVIE_ID}}",
                        arguments = listOf(
                            navArgument(StateConstants.PARAM_MOVIE_ID) { type = NavType.IntType }
                        )
                    ) { backStackEntry ->
                        MovieDetailScreen(
                            navController = navController,
                            bundle = backStackEntry.arguments ?: Bundle.EMPTY
                        )
                    }
                }
            }
        }

        "Hello world!".log()
    }
}
