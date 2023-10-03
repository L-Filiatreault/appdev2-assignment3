package com.example.assignment3.SupportingFiles

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assignment3.LocalNavController
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
    object ListScreen: Routes("ListScreenRoute")
}

@Composable
fun Router(modifier: Modifier) {
    val navController= LocalNavController.current

    NavHost(navController = navController, startDestination = "MainScreenRoute") {
        composable(Routes.Main.route)
        {
            MainScreen(modifier)
        }
        composable(Routes.Details.route)
        {
            val indexNumber2 = it.arguments?.getString("indexNumber") !!

            DetailsScreen(
                indexNumber2,
                modifier
            )
        }
        composable(Routes.Information.route)
        {
            InformationScreen(modifier)
        }

        //Create composable for the list screen here
        composable(Routes.ListScreen.route)
        {
            ListScreen(modifier)
        }

    }
}