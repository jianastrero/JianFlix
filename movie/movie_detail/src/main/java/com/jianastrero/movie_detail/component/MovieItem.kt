package com.jianastrero.movie_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
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
import com.jianastrero.common_ui.ui.theme.Amber500
import com.jianastrero.common_ui.ui.theme.PrimaryDark
import com.jianastrero.core.util.iTunesArtworkUrlResize
import com.jianastrero.movie_domain.model.Movie

/**
 * Movie Items for suggested movies
 *
 * @param movie The movie to show
 * @param onClick invoked when this composable function is clicked
 *
 * @author Jian James P. Astrero
 */
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
            .clickable { onClick(movie) }
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
                            PrimaryDark
                        ),
                        startY = 0f,
                        endY = size.height.toFloat(),
                    )
                )
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = movie.name,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Black
            )
            if (movie.viewed) {
                Text(
                    text = "Viewed",
                    color = Amber500.copy(alpha = 0.7f),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                )
            }
        }
    }
}