package br.com.ecowatt.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.ecowatt.R
import br.com.ecowatt.ui.theme.EcoWattTheme

/**
 * Component that displays the top bar of the EcoWatt app.
 *
 * @param modifier The [Modifier] for this composable.
 * @param goBackFn Handles the back navigation action.
 * @param isChildScreen Indicates if the back navigation is enabled.
 * @param currentScreen The current [OldEnumScreens].
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun EcoWattTopBar(
    title: String,
    goBackFn: (() -> Unit)? = null
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (goBackFn != null) {
                IconButton(onClick = goBackFn) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.ic_description_go_back)
                    )
                }
            }
        }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun EcoWattTopBarPreview() {
    EcoWattTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            topBar = {
                EcoWattTopBar(title = "Teste")
            }
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {}
        }
    }
}