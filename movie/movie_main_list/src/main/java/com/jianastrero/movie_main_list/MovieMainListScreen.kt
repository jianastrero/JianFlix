package com.jianastrero.movie_main_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.jianastrero.common_ui.Screen
import com.jianastrero.common_ui.component.MovieItem
import com.jianastrero.common_ui.ui.theme.PrimaryDark
import com.jianastrero.core.util.log
import com.jianastrero.movie_main_list.component.NewReleaseMovie
import org.koin.androidx.compose.get

/**
 * Main Movie List or basically, Home
 *
 * @param navController The Navigation Controller for switching screens
 *
 * @author Jian James P. Astrero
 */
@ExperimentalCoilApi
@Composable
fun MovieMainListScreen(
    navController: NavController
) {
    val viewModel = get<MovieMainListViewModel>()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = PrimaryDark)
    ) {

        viewModel.state.value.latestMovie?.let { latestMovie ->
            item {
                NewReleaseMovie(movie = latestMovie)
            }
        }

        items(viewModel.state.value.moviesCategorizedByGenre.keys.toList()) { item ->

            val movies = viewModel.state.value
                .moviesCategorizedByGenre.getOrDefault(item, listOf())

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item,
                color = Color.White.copy(alpha = 0.5f),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
            LazyRow {
                itemsIndexed(movies) { index, item ->
                    if (index == 0) {
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                    MovieItem(
                        movie = item,
                        onClick = { movie ->
                            "movie clicked: ${movie.name}".log()
                            navController.navigate(
                                Screen.MovieDetailScreen.route + "/${movie.id}"
                            )
                        }
                    )
                    if (index == movies.size - 1) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }

        }
    }
}