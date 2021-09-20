package com.jianastrero.movie_detail

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.jianastrero.common_ui.Screen
import com.jianastrero.common_ui.component.ErrorPage
import com.jianastrero.common_ui.component.ExpandableText
import com.jianastrero.common_ui.ui.theme.Magenta500
import com.jianastrero.common_ui.ui.theme.PrimaryDark
import com.jianastrero.core.domain.ProgressState
import com.jianastrero.core.util.log
import com.jianastrero.core.util.toReadableHoursMinutesAndSeconds
import com.jianastrero.core.util.toReadableMonthDayYear
import com.jianastrero.movie_detail.component.MovieArtwork
import com.jianastrero.movie_detail.component.MovieItem
import com.jianastrero.movie_domain.model.Movie
import org.koin.androidx.compose.getStateViewModel

@ExperimentalCoilApi
@Composable
fun MovieDetailScreen(
    navController: NavController,
    bundle: Bundle
) {
    val viewModel = getStateViewModel<MovieDetailViewModel>(state = { bundle })

    viewModel.state.value.progressState.let { progressState ->
        when (progressState) {
            is ProgressState.Error -> {
                ErrorPage(message = progressState.message)
            }
            ProgressState.Loaded -> {
                MovieDetailLoadedScreen(navController = navController, viewModel = viewModel)
            }
            ProgressState.Loading -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    CircularProgressIndicator(color = Magenta500)
                    Text(
                        text = "Fetching movie from JianFlix...",
                        color = Color.White
                    )
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun MovieDetailLoadedScreen(
    navController: NavController,
    viewModel: MovieDetailViewModel
) {
    viewModel.state.value.movie?.let { movie ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = PrimaryDark)
        ) {
            item {
                Box(
                    contentAlignment = Alignment.TopStart
                ) {
                    MovieArtwork(movie = movie)
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )
                }
                Text(
                    text = movie.name,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Text(
                    text = movie.genre,
                    color = Color.White.copy(alpha = 0.5f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Text(
                    text = "Duration: ${movie.timeInMillis.toReadableHoursMinutesAndSeconds()}",
                    color = Color.White.copy(alpha = 0.5f),
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Text(
                    text = "Release Date: ${movie.releaseDate.toReadableMonthDayYear()}",
                    color = Color.White.copy(alpha = 0.5f),
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                ExpandableText(
                    text = movie.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "More like this",
                    color = Color.White.copy(alpha = 0.6f),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
            items(viewModel.state.value.movies) { movie ->
                MovieItem(
                    movie = movie,
                    onClick = {
                        "movie clicked: ${movie.name}".log()
                        navController.navigate(
                            Screen.MovieDetailScreen.route + "/${movie.id}"
                        ) {
                            popUpTo(Screen.MovieMainListScreen.route)
                        }
                    }
                )
            }
        }
    }
}