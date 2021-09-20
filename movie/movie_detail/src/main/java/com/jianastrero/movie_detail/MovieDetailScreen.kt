package com.jianastrero.movie_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jianastrero.common_ui.component.ExpandableText
import com.jianastrero.common_ui.ui.theme.PrimaryDark
import com.jianastrero.core.util.toReadableHoursMinutesAndSeconds
import com.jianastrero.core.util.toReadableMonthDayYear
import com.jianastrero.movie_detail.component.MovieArtwork
import com.jianastrero.movie_domain.model.Movie
import org.koin.androidx.compose.getStateViewModel

@Composable
fun MovieDetailScreen(
    movie: Movie,
    navController: NavController
) {
    val viewModel = getStateViewModel<MovieDetailViewModel>()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = PrimaryDark)
    ) {
        item {
            MovieArtwork(movie = movie)
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
        }
    }
}