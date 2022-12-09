package com.iebayirli.composedemo.presentation.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.iebayirli.composedemo.presentation.profile.ProfileRoute

const val profileRoute = "profile_route"

fun NavController.navigateProfile(navOptions: NavOptions? = null){
    this.navigate(profileRoute, navOptions)
}

fun NavGraphBuilder.profileScreen(
    goToFavoritesClick : () -> Unit
){
    composable(
        route = profileRoute
    ){
        ProfileRoute( goToFavoritesClick = goToFavoritesClick )
    }
}