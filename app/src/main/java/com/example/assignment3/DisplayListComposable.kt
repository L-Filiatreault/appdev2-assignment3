package com.example.assignment3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * This function takes in the pokemonGymList in its parameter, goes through each item in the list
 * to be sent into another function which will display the list items in a better way.
 * This function uses lazy column with a Modifier.height(400.dp) to avoid the app from crashing, since there is a verticalScrolling
 * modifier in the AddGymForm() function.
 * I got the function idea from the notes.
 */

@Composable
fun DisplayList(pokemonGymList: SnapshotStateList<String>) {
    Spacer(modifier = Modifier.padding(8.dp))
    Text(text = "Click on the Gym to remove it",
        style = MaterialTheme.typography.bodyMedium)
    Spacer(modifier = Modifier.padding(6.dp))
    LazyColumn( modifier = Modifier.height(400.dp))
    {
        //Going through the list items one-by-one, and sending them to the   DisplayListComposableStyled() function.
        //As well if the user clicks on a list item it will delete that item from the list and therefore the screen itself.
        items(pokemonGymList){ item ->
            Row( modifier = Modifier.clickable{pokemonGymList.remove(item)}){

                DisplayListComposableStyled(item)

            }

        }
    }
}