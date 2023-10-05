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



/**
 * The data class is used to create instances to hold data about navigation bar icons and display their information
 * It stores String information about the route to a specific screen, the ImageVector of the icon used to represent
 * that screen, and the String information name about the screen
 */
data class NavBarIcon(val route: String, val icon: ImageVector, val name: String)


/**
 * The BottomBar Composable is storing all the features of the bottom navigation bar, allowing the user to select different screens.
 * It's primarily used to navigate between and display the icons of the different screens the user may access.
 * It highlights the icon of the screen the user is currently accessing.
 */
@Composable
fun BottomBar()
{


    val pokemonListCurrent = LocalPokemonList.current  //Using pokemonListCurrent to provide real-time information so the Details page icon will be rendered when the user has given data to add to the list
    val navController = LocalNavController.current //This is used to access different screens that are indicated by icons on the bottom navigation abr
    val navBackStackEntry by navController.currentBackStackEntryAsState() //It allows the user to use the NavController, used as a source of truth for updating the composables outside of the screen
    val currentDestination = navBackStackEntry?.destination //Retrieves the current entry associated with the destination, in other words it sets the current screen as our current destination, Useful for highlighting the icons the user is currently on


    //A mutable list of all the different navigation bar icons to render and what screens to route to when the user selects the icon
    val items = mutableListOf<NavBarIcon>(NavBarIcon(route= Routes.Main.route, icon= Icons.Outlined.AddCircle, name="Main"),
        NavBarIcon(route= Routes.ListScreen.route, icon= Icons.Outlined.List, name ="List"))

    //Adding the Details page Icon to show up between the Home and List screens, only if our pokemonGymList is populated. When it's size is 0 then Details screen icon won't render, otherwise it will display on the bottom navigation bar
    if(!pokemonListCurrent.isEmpty())
    {
        //This stores the index of the list we want to access, set to '1' so it's not undefined
        var firstIndex = 1;
        //Retrieving the last entered pokemon gym object to keep our details current
        var pokemonGymObject = pokemonListCurrent.last();
        //Transforming the selectedIndex into a string-value here so the routes can read it properly and retrieve the currently-added item page
        var selectedIndex = pokemonListCurrent.indexOf(pokemonGymObject).toString()

        //Adding the 'Details' icon to the items list so it will be rendered and accessible
         items.add(firstIndex,NavBarIcon(route= Routes.Details.go(selectedIndex), icon= Icons.Outlined.CheckCircle, name="Details"))
    }

    //Took this from our class slides to make sure our currently selected icon
    //is highlighted and the current route is correctly selected
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