package br.com.ecowatt.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import br.com.ecowatt.R

@Composable
fun DeviceListItem(
    headlineText: String,
    supportText: String,
    modifier: Modifier = Modifier,
    onRemove: () -> Unit = {}
) {
    ListItem(
        modifier = modifier,
        headlineContent = { Text(headlineText) },
        supportingContent = { Text(supportText) },
        trailingContent = {
            IconButton(onClick = onRemove) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(R.string.ic_description_delete_device)
                )
            }
        }
    )
}