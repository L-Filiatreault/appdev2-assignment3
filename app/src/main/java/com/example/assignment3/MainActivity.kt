package com.example.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier

import androidx.navigation.compose.rememberNavController
import com.example.assignment3.ui.theme.Assignment3Theme

import androidx.navigation.NavHostController

import com.example.assignment3.layouts.MainLayout


val LocalNavController = compositionLocalOf<NavHostController> { error("No NavController found!") }

data class PokemonGymInput(val gymLocation: String, val gymLeader: String, val gymImageUrl: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    val pokemonGymList = rememberMutableStateListOf<String>()
                    val navController = rememberNavController()
                    CompositionLocalProvider(LocalNavController provides navController)
                    {
                        MainLayout()
                        {
                            Router(modifier = Modifier, pokemonGymList)
                        }
                    }
                }
            }
        }
    }
}


