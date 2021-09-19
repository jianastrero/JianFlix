package com.jianastrero.common_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.jianastrero.core.util.iTunesArtworkUrlResize
import com.jianastrero.core.util.toCurrency
import com.jianastrero.jianflix.ui.theme.Magenta500
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
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(120.dp)
            .padding(horizontal = 4.dp)
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = modifier
                .fillMaxWidth()
                .height(160.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            val painter = rememberImagePainter(
                data = movie.artwork.iTunesArtworkUrlResize(140.dp.value.toInt()),
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
        Text(
            text = movie.name,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}