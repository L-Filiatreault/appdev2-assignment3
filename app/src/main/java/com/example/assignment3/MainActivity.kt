package com.example.assignment3

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier

import androidx.navigation.compose.rememberNavController
import com.example.assignment3.ui.theme.Assignment3Theme

import androidx.navigation.NavHostController
import kotlinx.parcelize.Parcelize
import com.example.assignment3.layouts.MainLayout

@Parcelize
data class PokemonGymInformation(val gymName: String, val gymLeader: String, val gymImageUrl: String): Parcelable
val LocalPokemonList = compositionLocalOf <SnapshotStateList<PokemonGymInformation>>{ error("No LocalPokemonList found!") }
val LocalNavController = compositionLocalOf<NavHostController> { error("No NavController found!") }



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

                    val pokemonGymList = rememberMutableStateListOf<PokemonGymInformation>()
                    val navController = rememberNavController()
                    CompositionLocalProvider(LocalNavController provides navController)
                    {
                        CompositionLocalProvider(LocalPokemonList provides pokemonGymList)
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
}


