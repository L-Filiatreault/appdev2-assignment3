package com.example.assignment3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assignment3.Screens.DetailsScreen
import com.example.assignment3.Screens.InformationScreen
import com.example.assignment3.Screens.ListScreen
import com.example.assignment3.Screens.MainScreen

sealed class Routes(val route:String)
{
    object Main: Routes("MainScreenRoute")

    object Information: Routes("InformationScreenRoute")

    object Details: Routes("DetailsScreenRoute/{indexNumber}"){
        fun go(indexNumber: String) = "DetailsScreenRoute/$indexNumber"
    }

    //Make the path for the List screen here
    object ListScreen: Routes("ListScreenRoute")
}

@Composable
fun Router(modifier: Modifier, pokemonGymList: SnapshotStateList<PokemonGymInformation>) {
    val navController= LocalNavController.current

    CompositionLocalProvider(LocalNavController provides navController){

        NavHost(navController = navController, startDestination = "MainScreenRoute") {
            composable(Routes.Main.route)
            {
                MainScreen(modifier =Modifier, pokemonGymList)
            }
            composable(Routes.Details.route)
            {
                val indexNumber2 = it.arguments?.getString("indexNumber") !!

                DetailsScreen(
                    indexNumber2,
                    modifier = Modifier
                )
            }
            composable(Routes.Information.route)
            {
                InformationScreen(modifier = Modifier)
            }

            //Create composable for the list screen here
            composable(Routes.ListScreen.route)
            {
                ListScreen(modifier = Modifier)
            }
        }

    }
}