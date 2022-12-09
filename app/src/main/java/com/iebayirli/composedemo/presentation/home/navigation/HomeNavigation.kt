package com.iebayirli.composedemo.presentation.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.iebayirli.composedemo.presentation.home.HomeRoute

const val homeRoute = "home_route"

fun NavController.navigateHome(navOptions: NavOptions? = null){
    this.navigate(homeRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(){
    composable(
        route = homeRoute
    ){
        HomeRoute()
    }
}