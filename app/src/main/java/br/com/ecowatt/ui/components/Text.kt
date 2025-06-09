package br.com.ecowatt.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
internal fun LargeTitle(
    text: String,
    fontSize: TextUnit = 48.sp,
    fontWeight: FontWeight = FontWeight.SemiBold,
    letterSpacing: TextUnit = 0.5.sp,
    lineHeight: TextUnit = 48.sp * 1.2
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing,
        lineHeight = lineHeight
    )
}

@Composable
fun Title(
    text: String,
    fontSize: TextUnit = 32.sp,
    fontWeight: FontWeight = FontWeight.SemiBold,
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
}

@Composable
internal fun SubTitle(
    text: String,
    fontSize: TextUnit = 24.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = MaterialTheme.colorScheme.onSurfaceVariant,
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color,
    )
}

@Composable
fun ButtonText(
    text: String,
    fontSize: TextUnit = 18.sp,
    fontWeight: FontWeight = FontWeight.SemiBold,
    letterSpacing: TextUnit = 0.5.sp
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing
    )
}