package com.iebayirli.composedemo.presentation.favorites.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.iebayirli.composedemo.presentation.favorites.FavoritesRoute

const val favoritesRoute= "favorites_route"

fun NavController.navigateFavorites(navOptions: NavOptions? = null){
    this.navigate(favoritesRoute, navOptions)
}

fun NavGraphBuilder.favoritesScreen(){
    composable(
        route = favoritesRoute
    ){
        FavoritesRoute()
    }
}