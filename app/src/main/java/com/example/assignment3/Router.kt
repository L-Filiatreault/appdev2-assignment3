package com.example.assignment3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assignment3.Screens.DetailsScreen
import com.example.assignment3.Screens.InformationScreen
import com.example.assignment3.Screens.MainScreen

sealed class Routes(val route:String)
{
    object Main: Routes("MainScreenRoute")

    object Information: Routes("InformationScreenRoute")

    object Details: Routes("DetailsScreenRoute/{location}/{gymLeader}/{gymBuildingURL}"){
        fun go(location: String, gymLeader: String, gymBuildingURL: String) = "DetailsScreenRoute/$location/$gymLeader/$gymBuildingURL"
    }

    //Make the path for the List screen here
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
                DetailsScreen(
                    it.arguments?.getString("location") ?: "",
                    it.arguments?.getString("gymLeader") ?: "",
                    it.arguments?.getString("imageUrl") ?: "",
                    modifier
                )
            }
            composable(Routes.Information.route)
            {
                InformationScreen(modifier = Modifier)
            }

            //Create composable for the list screen here
        }

    }
}