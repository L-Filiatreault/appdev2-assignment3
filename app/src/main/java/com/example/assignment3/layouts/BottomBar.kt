package com.example.assignment3.layouts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.assignment3.LocalNavController
import com.example.assignment3.Routes

data class NavBarIcon(
    val route: String,
    val icon: ImageVector
)


//Disable this until user has entered in some stuff


val items = listOf(NavBarIcon(route= Routes.Main.route, icon= Icons.Outlined.Home),
    NavBarIcon(route= Routes.ListScreen.route, icon= Icons.Outlined.List))
    //NavBarIcon(route= Routes.Details.go("Pewter City", "Brock", "https://staticg.sportskeeda.com/editor/2021/03/ddff5-16153318599864.png"), icon= Icons.Outlined.Place))


@Composable
fun BottomBar()
{
    val navController = LocalNavController.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.route) },
                selected = currentDestination?.hierarchy?.any {
                    currentDestination.route?.substringBefore('/') ==
                            item.route.substringBefore('/') } == true,
                onClick = { navController.navigate(item.route)}
            )
        }
    }

}