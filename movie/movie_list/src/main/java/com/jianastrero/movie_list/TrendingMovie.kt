package com.jianastrero.movie_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.jianastrero.common_ui.GradientLetterBox
import com.jianastrero.core.util.iTunesArtworkUrlResize
import com.jianastrero.movie_domain.model.Movie
import com.jianastrero.movie_list.ui.PrimaryDark

@ExperimentalCoilApi
@Composable
fun TrendingMovie(
    movie: Movie
) {
    var size by remember { mutableStateOf(IntSize.Zero) }
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        GradientLetterBox(
            color = PrimaryDark,
            contentAlignment = Alignment.BottomCenter,
            height = size.height,
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .onSizeChanged {
                    size = it
                }
        ) {
            val painter = rememberImagePainter(
                data = movie.artwork.iTunesArtworkUrlResize((size.width / 1.6).toInt()),
                builder = {

                }
            )
            Image(
                alignment = Alignment.Center,
                contentDescription = "Feature Movie",
                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painter,
            )
        }
        Text(
            text = movie.name,
            color = Color.White
        )
    }
}