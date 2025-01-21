package ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ui.components.textBox.pickers.OcIconButton
import ui.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TopBar(
    navController: NavController,
    title: String = "Top app bar",
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier) {

    var showBackArrow by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text(title)
        },
        modifier = modifier,
        navigationIcon = {
            if (showBackArrow == false) {
                OcIconButton(
                    onClickAction = {
                        onMenuClick()
                        showBackArrow = !showBackArrow},
                    icon = Icons.Default.Menu,
//                    enabled = !showBackArrow,
                    contentDescription = "//--Place Holder--//",
                    modifier = modifier
                )
            }
            else{
                OcIconButton(
                    onClickAction = {
                        navController.popBackStack(route = Routes.Home.name, false)
                        showBackArrow = !showBackArrow},
                    icon = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "//--Place Holder--//"
                )
            }
        }
    )
}