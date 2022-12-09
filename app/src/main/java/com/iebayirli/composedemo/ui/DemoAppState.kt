package com.iebayirli.composedemo.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.iebayirli.composedemo.navigation.TopLevelDestinations
import com.iebayirli.composedemo.presentation.home.navigation.homeRoute
import com.iebayirli.composedemo.presentation.home.navigation.navigateHome
import com.iebayirli.composedemo.presentation.profile.navigation.navigateProfile
import com.iebayirli.composedemo.presentation.profile.navigation.profileRoute

@Composable
fun rememberDemoAppState(
    navController: NavHostController = rememberNavController()
): DemoAppState {
    return remember(navController) {
        DemoAppState(navController)
    }
}

@Stable
class DemoAppState(
    val navController: NavHostController
) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestinations?
        @Composable get() = when (currentDestination?.route) {
            homeRoute -> TopLevelDestinations.HOME
            profileRoute -> TopLevelDestinations.PROFILE
            else -> null
        }

    val topLevelDestinations: List<TopLevelDestinations> = TopLevelDestinations.values().toList()

    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateTopLevelDestination(destination: TopLevelDestinations) {
        val navOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (destination) {
            TopLevelDestinations.HOME -> navController.navigateHome(navOptions)
            TopLevelDestinations.PROFILE -> navController.navigateProfile(navOptions)
        }

    }

    fun onBackPressed() {
        navController.popBackStack()
    }

}