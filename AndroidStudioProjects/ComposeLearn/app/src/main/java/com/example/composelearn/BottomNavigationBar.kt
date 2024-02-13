package com.example.composelearn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelearn.data.BottomNavigation

@Preview
@Composable
fun BottomNavigationBar() {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.forEachIndexed{index , item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = {
                        selectedItemIndex = index
                    },
                    icon = {
                        Icon(
                            imageVector = if(index == selectedItemIndex) item.iconSelected else item.iconUnselected,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(text = item.title, color = MaterialTheme.colorScheme.onBackground)
                    }
                )
            }

        }
    }
}

val items = listOf(
    BottomNavigation("Home", Icons.Filled.Home, Icons.Outlined.Home),
    BottomNavigation("Wallet", Icons.Filled.Wallet, Icons.Outlined.Wallet),
    BottomNavigation("Notification", Icons.Filled.Notifications, Icons.Outlined.Notifications),
    BottomNavigation("Account", Icons.Filled.AccountCircle, Icons.Outlined.AccountCircle),

)

