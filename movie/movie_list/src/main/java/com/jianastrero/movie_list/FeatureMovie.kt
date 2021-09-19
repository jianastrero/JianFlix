package com.jianastrero.movie_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.jianastrero.core.util.iTunesArtworkUrlResize
import com.jianastrero.movie_domain.model.Movie

@ExperimentalCoilApi
@Composable
fun FeatureMovie(
    movie: Movie
) {
    var size by remember { mutableStateOf(IntSize.Zero) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .onSizeChanged {
                    size = it
                }
        ) {
            val painter = coil.compose.rememberImagePainter(
                data = movie.artwork.iTunesArtworkUrlResize((size.width / 1.6).toInt()),
                builder = {

                }
            )
            Image(
                alignment = androidx.compose.ui.Alignment.Companion.Center,
                contentDescription = "Feature Movie",
                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painter,
            )
        }
    }
}