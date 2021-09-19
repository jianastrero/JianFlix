package com.jianastrero.movie_main_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.jianastrero.common_ui.GradientLetterBox
import com.jianastrero.core.util.iTunesArtworkUrlResize
import com.jianastrero.jianflix.ui.theme.Magenta500
import com.jianastrero.jianflix.ui.theme.PrimaryDark
import com.jianastrero.movie_domain.model.Movie

/**
 * Composable ui to show new release movie
 *
 * @param movie The movie to show in the NewReleaseMovie composable.
 *
 * @author Jian James P. Astrero
 */
@ExperimentalCoilApi
@Composable
fun NewReleaseMovie(
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
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = movie.name,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = "New on JianFlix",
                color = Magenta500
            )
        }
    }
}