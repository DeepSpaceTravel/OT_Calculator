package ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.components.textBox.pickers.OcIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TopBar(
    title: String = "Top app bar",
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier) {

    TopAppBar(
        title = {
            Text(title)
        },
        navigationIcon = {
            OcIconButton(
                onClickAction = onMenuClick,
                icon = Icons.Default.Menu,
                contentDescription = "//--Place Holder--//",
                modifier = modifier
            )
        },
        modifier = modifier
    )
}