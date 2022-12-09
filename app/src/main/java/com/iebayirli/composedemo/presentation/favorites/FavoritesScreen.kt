package com.iebayirli.composedemo.presentation.favorites

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.iebayirli.composedemo.R
import com.iebayirli.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun FavoritesRoute(
    modifier: Modifier = Modifier,
    favoritesViewModel: FavoritesViewModel = hiltViewModel()
) {
    FavoritesScreen(
        modifier = modifier
    )
}

@Composable
fun FavoritesScreen(
    modifier: Modifier
) {
    Box(
        modifier = modifier
    ){
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(id = R.string.title_bottom_favorites)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    ComposeDemoTheme {
        FavoritesScreen(modifier = Modifier.fillMaxSize())
    }
}