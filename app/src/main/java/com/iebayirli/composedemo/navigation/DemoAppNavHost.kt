package com.iebayirli.composedemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.iebayirli.composedemo.presentation.favorites.navigation.favoritesScreen
import com.iebayirli.composedemo.presentation.favorites.navigation.navigateFavorites
import com.iebayirli.composedemo.presentation.home.navigation.homeRoute
import com.iebayirli.composedemo.presentation.home.navigation.homeScreen
import com.iebayirli.composedemo.presentation.profile.navigation.profileScreen


@Composable
fun DemoAppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    onBackClick: () -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = homeRoute
    ){
        homeScreen()
        profileScreen(
            goToFavoritesClick = {
                navController.navigateFavorites()
            }
        )
        favoritesScreen()
    }
}