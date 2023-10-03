package com.example.assignment3.layouts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.assignment3.LocalNavController
import com.example.assignment3.LocalPokemonList
import com.example.assignment3.SupportingFiles.Routes

data class NavBarIcon(
    val route: String,
    val icon: ImageVector,
    val name: String

)

@Composable
fun BottomBar()
{

    val pokemonListCurrent = LocalPokemonList.current
    val navController = LocalNavController.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    val items = mutableListOf<NavBarIcon>(NavBarIcon(route= Routes.Main.route, icon= Icons.Outlined.AddCircle, name="Main"),
        NavBarIcon(route= Routes.ListScreen.route, icon= Icons.Outlined.List, name ="List"))

    //Adding the Details page Icon to show up between the Home and List screens, only if our list is populated
    if(!pokemonListCurrent.isEmpty())
    {
        var firstIndex = 1;
        //Retrieving the last entered pokemon gym object to keep our details current
        var pokemonGymObject = pokemonListCurrent.last();

        //Transforming it into a string ehre so our routes can read it
        var selectedIndex = pokemonListCurrent.indexOf(pokemonGymObject).toString()

         items.add(firstIndex,NavBarIcon(route= Routes.Details.go(selectedIndex), icon= Icons.Outlined.CheckCircle, name="Details"))
    }
    //Took this from our class slides to make sure our currently selected icon is highlighted

    NavigationBar {
        items.forEachIndexed { index, item ->

            NavigationBarItem(
                icon = { Icon(item.icon,
                    contentDescription = item.route) },
                selected = currentDestination?.hierarchy?.any {
                    currentDestination.route?.substringBefore('/') ==
                            item.route.substringBefore('/') } == true,
                onClick = { navController.navigate(item.route)},
               label= {Text(item.name)}
            )


        }
    }

}