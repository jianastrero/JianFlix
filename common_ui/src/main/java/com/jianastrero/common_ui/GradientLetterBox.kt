package com.jianastrero.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun GradientLetterBox(
    color: Color,
    contentAlignment: Alignment,
    height: Int,
    modifier: Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        contentAlignment = contentAlignment,
        modifier = modifier
    ) {
        content()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            color.copy(alpha = 0.1f),
                            color
                        ),
                        startY = height / 3f,
                        endY = height.toFloat(),
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(color, Color.Transparent),
                        startY = 0f,
                        endY = height / 3f,
                    )
                )
        )
    }
}