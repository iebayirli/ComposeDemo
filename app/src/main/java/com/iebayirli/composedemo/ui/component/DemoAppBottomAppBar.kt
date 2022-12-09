package com.iebayirli.composedemo.ui.component

import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.iebayirli.composedemo.navigation.Icon
import com.iebayirli.composedemo.navigation.TopLevelDestinations

@Composable
fun DemoAppBottomAppBar(
    destinations: List<TopLevelDestinations>,
    onNavigateToDestination: (TopLevelDestinations) -> Unit,
    currentDestination: NavDestination?
) {
    BottomAppBar {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            BottomNavigationItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIconId
                    } else {
                        destination.unselectedIconId
                    }
                    when (icon) {
                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector, contentDescription = null
                        )

                        is Icon.DrawableResourceIcon -> Icon(
                            painter = painterResource(id = icon.id), contentDescription = null
                        )
                    }
                },
                label = { Text(stringResource(destination.title)) })
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestinations) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false