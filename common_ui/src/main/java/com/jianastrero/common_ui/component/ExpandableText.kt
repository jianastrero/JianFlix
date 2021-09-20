package com.jianastrero.common_ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.jianastrero.common_ui.ui.theme.Magenta500

/**
 * Expandable text composable to show a long text with read more
 *
 * @author Jian James P. Astrero
 */
@Composable
fun ExpandableText(
    text: String,
    modifier: Modifier = Modifier,
    collapsedLines: Int = 3
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .clickable {
                expanded = !expanded
            }
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 12.sp,
            maxLines = if (expanded) Int.MAX_VALUE else collapsedLines,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = if (expanded) "read less" else "read more",
            color = Magenta500,
            fontSize = 12.sp,
            textAlign = TextAlign.Right,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}