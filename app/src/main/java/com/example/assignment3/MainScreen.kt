package com.example.assignment3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment3.layouts.MainLayout

@Composable
fun MainScreen(modifier: Modifier)
{

    MainLayout(){
        val pokemonGymList = rememberMutableStateListOf<String>()

        //Using a card here because it looks stylish than the Box
        Card(modifier = modifier
            .fillMaxWidth()
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

                AddGymForm(lambda); //A function which takes input from the user and adds it to the list

                //Put this on the detailsScreen
                DisplayList(pokemonGymList); //A function to display information from the list
            }

        }
    }
}