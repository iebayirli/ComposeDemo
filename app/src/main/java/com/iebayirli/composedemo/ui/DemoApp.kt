package com.iebayirli.composedemo.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iebayirli.composedemo.navigation.DemoAppNavHost
import com.iebayirli.composedemo.ui.component.DemoAppBottomAppBar
import com.iebayirli.composedemo.ui.component.DemoAppTopAppBar

@Composable
fun DemoApp(
    appState: DemoAppState = rememberDemoAppState()
) {
    Scaffold(
        topBar = {
            val destination = appState.currentTopLevelDestination
            if (destination != null) {
                DemoAppTopAppBar(
                    titleRes = destination.title
                )
            }
        },
        bottomBar = {
            if (appState.currentTopLevelDestination != null) {
                DemoAppBottomAppBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateTopLevelDestination,
                    currentDestination = appState.currentDestination
                )
            }
        }
    ) { padding ->
        DemoAppNavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            navController = appState.navController,
            onBackClick = appState::onBackPressed
        )
    }
}