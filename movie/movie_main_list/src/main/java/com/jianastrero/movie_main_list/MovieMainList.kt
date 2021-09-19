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
import coil.annotation.ExperimentalCoilApi
import com.jianastrero.common_ui.component.MovieItem
import com.jianastrero.jianflix.ui.theme.PrimaryDark
import com.jianastrero.movie_domain.model.Movie
import org.koin.androidx.compose.get
import java.time.LocalDateTime

/**
 * Main Movie List or basically, Home
 *
 * @author Jian James P. Astrero
 */
@ExperimentalCoilApi
@Composable
fun MovieMainList() {

    val viewModel = get<MovieMainListViewModel>()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = PrimaryDark)
    ) {

        item {
            NewReleaseMovie(
                movie = Movie(
                    "https://is3-ssl.mzstatic.com/image/thumb/Video127/v4/d8/1e/03/d81e03d9-3d61-ce3d-dd05-ad511824a5b2/source/100x100bb.jpg",
                    "USD",
                    "J.J. Abrams STAR TREK INTO DARKNESS is the best-reviewed blockbuster of the year. When a ruthless mastermind known as Khan (Benedict Cumberbatch) declares a one-man war on the Federation, Captain Kirk (Chris Pine), Spock (Zachary Quinto), and the daring crew of the U.S.S. Enterprise will embark on the greatest manhunt in history. It will take all of their skills and teamwork to defend Earth and eliminate Khan’s threat in this “sleek, thrilling epic.” (Owen Gleiberman, Entertainment Weekly)",
                    "Sci-Fi & Fantasy",
                    1,
                    "Star Trek Into Darkness",
                    1f,
                    "https://video-ssl.itunes.apple.com/itunes-assets/Video127/v4/d1/d4/7a/d1d47a23-7ed3-f51d-ded1-12ab6ea3d5c6/mzvf_6689004818574290975.640x354.h264lc.U.p.m4v",
                    LocalDateTime.now(),
                    7965172L,
                    false
                )
            )
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
                        movie = item
                    )
                    if (index == movies.size - 1) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }

        }
    }
}