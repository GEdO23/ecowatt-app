package br.com.ecowatt.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times

sealed class CustomIconSize(val containerSize: Dp) {
    data object Base : CustomIconSize(32.dp);

    private val iconSizeMultiplier = 0.4
    val iconSize = iconSizeMultiplier * containerSize
}

@Composable
fun CustomIcon(
    @DrawableRes drawableId: Int,
    description: String,
    modifier: Modifier = Modifier,
    size: CustomIconSize = CustomIconSize.Base,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    containerShape: RoundedCornerShape = RoundedCornerShape(100),
    color: Color = MaterialTheme.colorScheme.onPrimary
) {
    Box(
        modifier = modifier
            .size(size.containerSize)
            .background(containerColor, containerShape)
    ) {
        Icon(
            painter = painterResource(drawableId),
            contentDescription = description,
            modifier = Modifier
                .size(size.iconSize)
                .align(Alignment.Center),
            tint = color
        )
    }
}