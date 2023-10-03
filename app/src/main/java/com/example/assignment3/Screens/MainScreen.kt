package com.example.assignment3.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment3.SupportingFiles.AddGymForm
import com.example.assignment3.LocalNavController
import com.example.assignment3.LocalPokemonList


/**
 * This function is for displaying the card and main overall look of the app.
 * It also stores the mutable pokemonGymList, sends the list to the AddGymForm() to get user input,
 * then sends the list to DisplayList() so it can display the information the user gave below the text fields
 */
@Composable
fun MainScreen(modifier: Modifier)
{

        //Using a card here because it looks stylish than the Box
    Card(modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
            border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.surfaceTint),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onSecondary
            )
        )
        {
            //Organizing the items inside parts that have to displayed in a uniformed manner
            Column( modifier = Modifier
                .verticalScroll(rememberScrollState()), //This is used since we didn't implement a lazylist on the Column, and we need to scroll through when the phone is rotated 90 degrees right or left
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                AddGymForm(); //A function which takes input from the user and adds it to the list

            }


    }
}