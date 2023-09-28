package com.example.assignment3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Router(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "MainScreenRoute") {
        composable("MainScreenRoute")
        {
            MainScreen(modifier)
        }
        composable("InformationScreenRoute")
        {
            //InformationScreen()
        }
    }
}