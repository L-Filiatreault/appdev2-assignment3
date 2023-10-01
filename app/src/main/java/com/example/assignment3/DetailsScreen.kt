package com.example.assignment3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


//I got the idea of using Image Coil to show the image from this video: https://www.youtube.com/watch?v=pbcAVtqZ8bg
@Composable
fun DetailsScreen(pokemonGymList: SnapshotStateList<String>, modifier: Modifier) {

    val navController = LocalNavController.current;
    var gymLeaderName  by rememberSaveable { mutableStateOf("") }
    var gymName  by rememberSaveable { mutableStateOf("") }
    var gymImageUrl  by rememberSaveable { mutableStateOf("") }

    //I used a similar technique in a Programming 3 assignment where I needed to split the information from a list using a delimiter
    //I used a joinToString() method because of this tutorial here: https://www.baeldung.com/kotlin/char-array-to-string
    //When I tried to make the item in the list into a string in order to split it at the '\n' I would get crashes
    //Therefore I had to use .joinToString() to make the element in the list into a string, which I could split at the '\n'

    val joinedString = pokemonGymList.toList().joinToString()
    val newPokemonGymInfoList = joinedString.split("\n")

    //Creating placeholders here in case the list wasn't populated beforehand and to prevent a crash
    if(pokemonGymList.isEmpty())
    {
        gymName = "Pewter City Gym"
        gymLeaderName = "Brock"
        gymImageUrl = "https://staticg.sportskeeda.com/editor/2021/03/ddff5-16153318599864.png" //Found this on a quick Google search

    }
    else
    {
        gymName = newPokemonGymInfoList[0]
        gymLeaderName = newPokemonGymInfoList[1]
        gymImageUrl = newPokemonGymInfoList[2]
    }


    Card(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(16.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.surfaceTint),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onTertiary
        )
    ){
        //Setting things inside a column to make it appear ordered
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(
                rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {

            Spacer(modifier = Modifier.padding(10.dp))


            Text(text = "Gym Name: $gymName",
                modifier = Modifier.padding(4.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    letterSpacing = 0.1.sp,
                    lineHeight = 30.sp
                )
            )
            Spacer(modifier = Modifier.padding(30.dp))

            Text(text ="Gym Leader: $gymLeaderName" ,
                modifier = Modifier.padding(4.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    letterSpacing = 0.1.sp,
                    lineHeight = 30.sp
                )
            )
            Spacer(modifier = Modifier.padding(10.dp))

            BuildingTheCoilImage(gymImageUrl)

        }

    }


}

