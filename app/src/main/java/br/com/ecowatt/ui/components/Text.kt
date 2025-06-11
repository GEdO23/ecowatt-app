package br.com.ecowatt.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times


internal object Text {
    
    @Composable
    fun LargeTitle(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = MaterialTheme.colorScheme.onSurface,
        size: TextUnit = 48.sp,
        weight: FontWeight = FontWeight.SemiBold,
        letterSpacing: TextUnit = 0.5.sp,
        lineHeight: Double = 1.2
    ) {
        Text(
            text = text,
            modifier = modifier,
            color = color,
            fontSize = size,
            fontWeight = weight,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight * size
        )
    }

    @Composable
    fun Title(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = MaterialTheme.colorScheme.onSurface,
        size: TextUnit = 32.sp,
        weight: FontWeight = FontWeight.SemiBold,
        letterSpacing: TextUnit = 0.sp,
        lineHeight: Double = 1.2
    ) {
        Text(
            text = text,
            modifier = modifier,
            color = color,
            fontSize = size,
            fontWeight = weight,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight * size
        )
    }

    @Composable
    fun SubTitle(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        size: TextUnit = 24.sp,
        fontWeight: FontWeight = FontWeight.Normal,
        letterSpacing: TextUnit = 0.sp,
        lineHeight: Double = 1.2
    ) {
        Text(
            text = text,
            modifier = modifier,
            color = color,
            fontSize = size,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight * size
        )
    }

    @Composable
    fun Paragraph(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        size: TextUnit = 18.sp,
        fontWeight: FontWeight = FontWeight.Normal,
        letterSpacing: TextUnit = 0.sp,
        lineHeight: Double = 1.5
    ) {
        Text(
            text = text,
            modifier = modifier,
            color = color,
            fontSize = size,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight * size
        )
    }

    @Composable
    fun ButtonText(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = MaterialTheme.colorScheme.onSurface,
        size: TextUnit = 18.sp,
        weight: FontWeight = FontWeight.SemiBold,
        letterSpacing: TextUnit = 0.sp,
        lineHeight: Double = 1.5
    ) {
        Text(
            text = text,
            modifier = modifier,
            color = color,
            fontSize = size,
            fontWeight = weight,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight * size
        )
    }
}
