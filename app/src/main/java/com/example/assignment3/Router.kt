package com.example.assignment3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

val LocalNavController = compositionLocalOf<NavHostController> { error("No NavController found!") }

@Composable
fun Router(modifier: Modifier) {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navController){
        NavHost(navController = navController, startDestination = "MainScreenRoute") {
            composable("MainScreenRoute")
            {
                MainScreen(modifier)
            }
            composable("DetailsScreenRoute")
            {
                DetailsScreen()
            }
            composable("InformationScreenRoute")
            {
                //InformationScreen()
            }
        }

    }
}