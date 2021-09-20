package com.jianastrero.movie_main_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.jianastrero.common_ui.component.GradientLetterBox
import com.jianastrero.common_ui.ui.theme.Amber500
import com.jianastrero.core.util.iTunesArtworkUrlResize
import com.jianastrero.common_ui.ui.theme.Magenta500
import com.jianastrero.common_ui.ui.theme.PrimaryDark
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
    movie: Movie,
    onClick: (Movie) -> Unit = {}
) {
    var size by remember { mutableStateOf(IntSize.Zero) }
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(movie) }
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
                contentScale = ContentScale.Crop,
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
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "New on JianFlix",
                    color = Magenta500,
                    fontSize = 16.sp
                )
                if (movie.viewed) {
                    Text(
                        text = "Viewed",
                        color = Amber500.copy(alpha = 0.6f),
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                }
            }
        }
    }
}