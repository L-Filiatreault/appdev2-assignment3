package com.example.assignment3

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
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/**
 * This function is for displaying the card and main overall look of the app.
 * It also stores the mutable pokemonGymList, sends the list to the AddGymForm() to get user input,
 * then sends the list to DisplayList() so it can display the information the user gave below the text fields
 */
@Composable
fun MainScreen(modifier: Modifier, pokemonGymList: SnapshotStateList<String>)
{
    val navController = LocalNavController.current




        //Using a card here because it looks stylish than the Box
    Card(modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
            border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.surfaceTint),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onTertiary
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

                var lambda : (String) -> Unit = {pokemonGymList.add(it)} //A lambda function to store all the text Values into the list to be outputted on the DisplayList()

                AddGymForm(lambda, navController); //A function which takes input from the user and adds it to the list

                //Put this on the detailsScreen
                //DisplayList(pokemonGymList); //A function to display information from the list
            }


    }
}