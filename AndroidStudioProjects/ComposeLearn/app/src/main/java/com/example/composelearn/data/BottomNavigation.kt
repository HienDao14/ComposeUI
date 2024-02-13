package com.example.composelearn.data

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigation(
    val title: String,
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector
)