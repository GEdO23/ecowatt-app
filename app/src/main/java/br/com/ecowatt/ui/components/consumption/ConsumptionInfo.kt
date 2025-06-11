package br.com.ecowatt.ui.components.consumption

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.R
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.ui.components.CustomIcon
import br.com.ecowatt.ui.components.Text.Paragraph

object ConsumptionInfo {

    @Composable
    fun DeviceConsumptionsInfo(
        device: Device,
        modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
            if (device.isConsumptionHigh) {
                ConsumptionLimitItem(
                    consumptionLimit = device.consumptionLimit,
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.error,
                    fontColor = MaterialTheme.colorScheme.error,
                    fontWeight = FontWeight.SemiBold
                )

                ConsumptionLevelItem(
                    consumptionLevel = device.latestConsumptionValue,
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.error,
                    fontColor = MaterialTheme.colorScheme.error,
                    fontWeight = FontWeight.SemiBold
                )
            } else {
                ConsumptionLimitItem(
                    consumptionLimit = device.consumptionLimit,
                    modifier = Modifier.fillMaxWidth()
                )
                ConsumptionLevelItem(
                    consumptionLevel = device.latestConsumptionValue,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

    @Composable
    private fun ConsumptionLimitItem(
        consumptionLimit: UInt,
        modifier: Modifier = Modifier,
        color: Color = MaterialTheme.colorScheme.primary,
        fontColor: Color = MaterialTheme.colorScheme.onSurface,
        fontWeight: FontWeight = FontWeight.Normal
    ) {
        ItemTemplate(
            text = stringResource(
                R.string.consumption_limit,
                consumptionLimit,
                stringResource(R.string.energy_unit)
            ),
            drawableId = R.drawable.ic_energy,
            drawableDescription = stringResource(R.string.ic_description_consumption_level),
            modifier = modifier,
            fontColor = fontColor,
            fontWeight = fontWeight,
            borderColor = color,
            iconContainerColor = color
        )
    }

    @Composable
    private fun ConsumptionLevelItem(
        consumptionLevel: UInt,
        modifier: Modifier = Modifier,
        color: Color = MaterialTheme.colorScheme.primary,
        fontColor: Color = MaterialTheme.colorScheme.onSurface,
        fontWeight: FontWeight = FontWeight.Normal
    ) {
        ItemTemplate(
            text = stringResource(
                R.string.energy_consumption_per_minute,
                consumptionLevel,
                stringResource(R.string.energy_unit)
            ),
            drawableId = R.drawable.ic_energy,
            drawableDescription = stringResource(R.string.ic_description_consumption_level),
            modifier = modifier,
            fontColor = fontColor,
            fontWeight = fontWeight,
            borderColor = color,
            iconContainerColor = color
        )
    }

    @Composable
    private fun ItemTemplate(
        text: String,
        @DrawableRes drawableId: Int,
        drawableDescription: String,
        modifier: Modifier = Modifier,
        fontColor: Color = MaterialTheme.colorScheme.onSurface,
        fontWeight: FontWeight = FontWeight.Normal,
        borderWidth: Dp = 2.dp,
        borderColor: Color = Color.Transparent,
        iconContainerColor: Color = MaterialTheme.colorScheme.primary,
        iconColor: Color = MaterialTheme.colorScheme.onPrimary,
        backgroundColor: Color = Color.Transparent,
        shape: RoundedCornerShape = RoundedCornerShape(24.dp),
        horizontalArrangement: Arrangement.HorizontalOrVertical = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .background(color = backgroundColor, shape = shape)
                .border(width = borderWidth, color = borderColor, shape = shape)
                .padding(12.dp)
        ) {
            CustomIcon(
                drawableId = drawableId,
                description = drawableDescription,
                containerColor = iconContainerColor,
                color = iconColor
            )

            Paragraph(
                text = text,
                color = fontColor,
                fontWeight = fontWeight,
                letterSpacing = 0.5.sp
            )
        }
    }
}


