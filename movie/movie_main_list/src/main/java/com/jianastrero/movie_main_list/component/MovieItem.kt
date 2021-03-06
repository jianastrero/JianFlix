package com.jianastrero.movie_main_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.jianastrero.common_ui.ui.theme.Amber500
import com.jianastrero.core.util.iTunesArtworkUrlResize
import com.jianastrero.core.util.toCurrency
import com.jianastrero.common_ui.ui.theme.Magenta500
import com.jianastrero.movie_domain.model.Movie

/**
 * Composable ui for a movie item
 *
 * @param movie The movie item to show in this composable.
 * @param modifier Modifiers for this composable.
 *
 * @author Jian James P. Astrero
 */
@Composable
fun MovieItem(
    movie: Movie,
    onClick: (Movie) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .width(120.dp)
            .padding(horizontal = 4.dp)
            .clickable {
                onClick(movie)
            }
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = modifier
                .fillMaxWidth()
                .height(160.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            val painter = rememberImagePainter(
                data = movie.artwork.iTunesArtworkUrlResize(140.dp.value.toInt())
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
            Column {
                if (movie.viewed) {
                    Text(
                        text = "VIEWED",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .background(color = Amber500)
                            .fillMaxWidth()
                    )
                }
                Text(
                    text = movie.price.toCurrency(movie.currency),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(color = Magenta500)
                        .fillMaxWidth()
                )
            }
        }
        Text(
            text = movie.name,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .height(((12 + 4) * 3).dp) // 12 - text size, 4 - line spacing, 3 - line count
        )
    }
}