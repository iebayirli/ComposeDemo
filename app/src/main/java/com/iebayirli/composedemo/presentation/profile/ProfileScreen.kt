package com.iebayirli.composedemo.presentation.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.iebayirli.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun ProfileRoute(
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel = hiltViewModel(),
    goToFavoritesClick: () -> Unit
) {

    ProfileScreen(
        modifier = modifier
            .fillMaxSize(),
        goToFavoritesClick = goToFavoritesClick
    )
}

@Composable
fun ProfileScreen(
    modifier: Modifier,
    goToFavoritesClick: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        Button(
            modifier = Modifier
                .align(Alignment.Center),
            onClick = { goToFavoritesClick() }
        ) {
            Text(
                modifier = Modifier,
                text = "Go to favorites"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ComposeDemoTheme {
        ProfileScreen(modifier = Modifier.fillMaxSize(), goToFavoritesClick = {})
    }
}