package com.example.assignment3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Routes(val route:String)
{
    object Main: Routes("MainScreenRoute")

    object Information: Routes("InformationScreenRoute")

    object Details: Routes("DetailsScreenRoute"){
        fun go(name: String, location: String) = "DetailsScreenRoute"
    }
}

data class PokemonGymInformation(val gymName: String, val gymLeader: String, val gymImageUrl: String)

@Composable
fun Router(modifier: Modifier, pokemonGymList: SnapshotStateList<String>) {
    val navController= LocalNavController.current




    CompositionLocalProvider(LocalNavController provides navController){

        NavHost(navController = navController, startDestination = "MainScreenRoute") {
            composable(Routes.Main.route)
            {
                MainScreen(modifier =Modifier, pokemonGymList)
            }
            composable(Routes.Details.route)
            {
                DetailsScreen(pokemonGymList, modifier =Modifier)
            }
            composable(Routes.Information.route)
            {
                //InformationScreen()
            }
        }

    }
}