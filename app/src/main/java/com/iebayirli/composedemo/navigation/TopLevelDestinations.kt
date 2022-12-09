package com.iebayirli.composedemo.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.iebayirli.composedemo.R

enum class TopLevelDestinations(
    val title: Int, val selectedIconId: Icon, val unselectedIconId: Icon
) {
    HOME(
        title = R.string.title_bottom_home,
        selectedIconId = Icon.ImageVectorIcon(Icons.Default.Home),
        unselectedIconId = Icon.ImageVectorIcon(Icons.Outlined.Home)
    ),
    PROFILE(
        title = R.string.title_bottom_profile,
        selectedIconId = Icon.DrawableResourceIcon(R.drawable.ic_profile),
        unselectedIconId = Icon.DrawableResourceIcon(R.drawable.ic_profile_border)
    )
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}