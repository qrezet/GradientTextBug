package com.example.gradienttext

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.InternalFoundationTextApi
import androidx.compose.foundation.text.TextDelegate
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFontLoader
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection

@InternalFoundationTextApi
@Composable
fun GradientText(
    text: String,
    brush: Brush,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    softWrap: Boolean = true,
    overflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = LocalTextStyle.current,
) {
    val density = LocalDensity.current
    val resourceLoader = LocalFontLoader.current

    BoxWithConstraints(
        modifier = modifier,
    ) {
        val textDelegate =
            remember(text, style, maxLines, softWrap, overflow, density, resourceLoader) {
                TextDelegate(
                    text = AnnotatedString(text),
                    style = style,
                    maxLines = maxLines,
                    softWrap = softWrap,
                    overflow = overflow,
                    density = density,
                    resourceLoader = resourceLoader,
                ).layout(constraints, LayoutDirection.Ltr)
            }

        with(density) {
            Canvas(
                modifier = Modifier.size(
                    width = textDelegate.size.width.toDp(),
                    height = textDelegate.size.height.toDp()
                )
            ) {
                TextDelegate.paint(drawContext.canvas, textDelegate)
                drawRect(
                    brush = brush,
                    blendMode = BlendMode.SrcIn
                )
            }
        }
    }
}
