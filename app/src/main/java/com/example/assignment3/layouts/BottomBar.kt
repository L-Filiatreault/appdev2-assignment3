package com.example.assignment3.layouts

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.assignment3.LocalNavController
import com.example.assignment3.LocalPokemonList
import com.example.assignment3.Routes

data class NavBarIcon(
    val route: String,
    val icon: ImageVector
)


//Disable this until user has entered in some stuff




@Composable
fun BottomBar()
{
    val pokemonListCurrent = LocalPokemonList.current
    val navController = LocalNavController.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    val items = mutableListOf<NavBarIcon>(NavBarIcon(route= Routes.Main.route, icon= Icons.Outlined.Home),
        NavBarIcon(route= Routes.ListScreen.route, icon= Icons.Outlined.List))

    //Adding the Details page Icon to show up between the Home and List screens, only if our list is populated
    if(!pokemonListCurrent.isEmpty())
    {
         items.add(1,NavBarIcon(route= Routes.Details.go("0"), icon= Icons.Outlined.Place))
    }





    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.route) },
                label={item.route},
                selected = currentDestination?.hierarchy?.any {
                    currentDestination.route?.substringBefore('/') ==
                            item.route.substringBefore('/') } == true,
                onClick = { navController.navigate(item.route)},
                modifier = Modifier
                    .padding(8.dp)
                    .size(24.dp)
            )
        }
    }

}