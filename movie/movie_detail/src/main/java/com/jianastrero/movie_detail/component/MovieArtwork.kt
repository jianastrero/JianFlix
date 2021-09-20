package com.jianastrero.movie_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.jianastrero.common_ui.component.GradientLetterBox
import com.jianastrero.common_ui.ui.theme.PrimaryDark
import com.jianastrero.core.util.iTunesArtworkUrlResize
import com.jianastrero.movie_domain.model.Movie

@Composable
fun MovieArtwork(
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
                .height(380.dp)
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
                contentDescription = "Movie Artwork",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painter,
            )
        }
    }
}