package br.com.ecowatt.ui.components

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
internal fun LargeTitle(text: String) {
    Text(
        text = text,
        fontSize = 48.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.5.sp,
        lineHeight = 48.sp * 1.2
    )
}

@Composable
fun Title(text: String) {
    Text(
        text = text,
        fontSize = 32.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
internal fun SubTitle(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
    )
}

@Composable
internal fun Paragraph(@StringRes text: Int) {

}

@Composable
fun ButtonText(text: String) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.5.sp
    )
}