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
 * This function MainScreen is for displaying the card and main overall look of the app.
 * It is the screen the user lands on when initially starting the app, and it calls AddGymForm()
 * composable so to display the different text fields the user can enter their information in.
 */
@Composable
fun MainScreen(modifier: Modifier)
{
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
                .verticalScroll(rememberScrollState()), //Using this so when the screen is rotated the screen is still scrollable by the user, it won't remain static
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                AddGymForm(); //A function which takes input from the user and adds it to the list
            }


    }
}