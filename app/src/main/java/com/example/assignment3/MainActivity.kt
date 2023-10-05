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
import com.example.assignment3.SupportingFiles.Router
import com.example.assignment3.SupportingFiles.rememberMutableStateListOf
import kotlinx.parcelize.Parcelize
import com.example.assignment3.layouts.MainLayout




//////////////////////////////////////////////////////
//==ASSIGNMENT 3: POKEMON GYM MULTI-SCREEN APP==//
//////////////////////////////////////////////////////

/**
 * Student: Lauren Filiatreault
 * Student Id: 0474461
 * Date: October 4, 2023
 */

/**
 * This assignment is a multi-screen application that uses Kotlin and Jetpack Compose
 * to interact with the user and uses state to retain information the user inputted.
 * It's a Pokemon Gym app that trainers can use to store the different gyms they have visited,
 * read details about that gym, and delete the gym items from a list.
 *
 * This assignment focuses on navigation, shared layouts, multiple screens that display different pieces of information
 * and includes displaying images. It demonstrates a good separation of stateless and stateful composables,
 * using multiple components and attention to layout.
 */

/**
 * The data class PokemonGymInformation creates instances of gym information to hold data given by the user, and displays it on separate screens.
 * This data class takes input given by the user, and displays the words for the gym name, the gym leader, and it takes in
 * an external image link url to display an image on the Details and List screens.
 * */
@Parcelize
data class PokemonGymInformation(val gymName: String, val gymLeader: String, val gymImageUrl: String): Parcelable

//LocalPokemonList will act as our SnapshotStateList which holds information about the data class PokemonGymInformation, and store information of all the different gyms visited by the user
//It will be used across different screens with the Provider pattern so there isn't unnecessary passing of stateful data into screens which don't require it
val LocalPokemonList = compositionLocalOf <SnapshotStateList<PokemonGymInformation>>{ error("No LocalPokemonList found!") }

//LocalNavController will act as a way to access the NavHostController across different screens with using the Provider pattern
val LocalNavController = compositionLocalOf<NavHostController> { error("No NavController found!") }

/**
 * Main Activity is the file which sets up the project, and holds both the Providers for LocalNavController and LocalPokemonList to different screens
 * in order to access different screens and store Pokemon gym data. It calls the Router Composable so as to create navigation between different screens.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onSecondary
                ) {

                    //This is the original list that stores data types of PokemonGymInformation, so data can be added and removed from this list in real-time by the user
                    //It's used across several screens by the LocalPokemonList provider
                    val pokemonGymList = rememberMutableStateListOf<PokemonGymInformation>()

                    //This is the navigation controller that will aid in accessing different screens from other screens or in the navigation bar
                    val navController = rememberNavController()

                    //This is where the LocalNavController gives a way for passing the data flow down through the composition with the navController without needlessly passing it through several screens
                    CompositionLocalProvider(LocalNavController provides navController)
                    {
                        //This provides a way to access and edit the pokemonGymList by passing it to certain nodes of the UI tree without passing it through several screens
                        CompositionLocalProvider(LocalPokemonList provides pokemonGymList)
                        {
                            MainLayout()
                            {
                                Router(modifier = Modifier)
                            }
                        }
                    }
                }
            }
        }
    }
}


