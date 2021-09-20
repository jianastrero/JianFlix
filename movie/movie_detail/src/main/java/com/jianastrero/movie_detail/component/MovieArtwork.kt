package com.jianastrero.movie_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.jianastrero.common_ui.component.GradientLetterBox
import com.jianastrero.common_ui.ui.theme.Amber500
import com.jianastrero.common_ui.ui.theme.Magenta500
import com.jianastrero.common_ui.ui.theme.PrimaryDark
import com.jianastrero.core.util.iTunesArtworkUrlResize
import com.jianastrero.core.util.toCurrency
import com.jianastrero.movie_domain.model.Movie

@Composable
fun MovieArtwork(
    movie: Movie
) {
    var size by remember { mutableStateOf(IntSize.Zero) }
    Box(
        contentAlignment = Alignment.BottomEnd,
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
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .padding(vertical = 8.dp)
        ) {
            if (movie.viewed) {
                Box(
                    modifier = Modifier
                        .alpha(0.5f)
                        .clip(
                            RoundedCornerShape(
                                topStart = 4.dp,
                                bottomStart = 4.dp
                            )
                        )
                ) {
                    Text(
                        text = "VIEWED",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .background(Amber500)
                            .padding(6.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 4.dp,
                            bottomStart = 4.dp
                        )
                    )
            ) {
                Text(
                    text = movie.price.toCurrency(movie.currency),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(Magenta500)
                        .padding(6.dp)
                )
            }
        }
    }
}