package org.example.project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.touchlab.kermit.Logger
import com.example.project.AppTheme
import di.commonModule
import di.platformModule
import logging.initLogger
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinMultiplatformApplication
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.KoinConfiguration
import ui.components.TopBar
import ui.navigation.Routes
import ui.screens.CalculationScreen
import ui.screens.EntryListScreen

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App(
    navController: NavHostController = rememberNavController()
) {
    initLogger()
    KoinMultiplatformApplication(
        config = KoinConfiguration {
            modules(
                platformModule(),
                commonModule()
            )
        }
    ){
        Logger.i { "Koin initialized" }
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                MaterialTheme {
                    Column(
                        Modifier.fillMaxWidth()
                            .windowInsetsPadding(WindowInsets.statusBars),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TopBar(
                            onMenuClick = { navController.navigate(route = Routes.EntryList.name) },
                            navController = navController
                        )

                        NavHost(
                            navController = navController,
                            startDestination = Routes.Home.name,
//                            Comment this out to see what happens, an annoying little layout bug
                            modifier = Modifier.fillMaxSize()
                        ) {
                            composable(route = Routes.Home.name) {
                                CalculationScreen()
                            }
                            composable(route = Routes.EntryList.name) {
                                EntryListScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}