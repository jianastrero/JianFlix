package com.jianastrero.movie_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.jianastrero.common_ui.ui.theme.PrimaryDark
import com.jianastrero.core.util.iTunesArtworkUrlResize
import com.jianastrero.movie_domain.model.Movie

@ExperimentalCoilApi
@Composable
fun MovieItem(
    movie: Movie,
    onClick: (Movie) -> Unit = { }
) {
    var size by remember { mutableStateOf(IntSize.Zero) }

    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .onSizeChanged {
                size = it
            }
    ) {
        val painter = rememberImagePainter(
            data = movie.artwork.iTunesArtworkUrlResize((size.width / 1.6).toInt())
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            PrimaryDark.copy(alpha = 0.1f),
                            PrimaryDark
                        ),
                        startY = 0f,
                        endY = size.height.toFloat(),
                    )
                )
        )
        Text(
            text = movie.name,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier.
                    padding(8.dp)
        )
    }
}