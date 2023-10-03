package com.example.assignment3.Screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment3.BuildingTheCoilImage
import com.example.assignment3.LocalNavController
import com.example.assignment3.LocalPokemonList
import com.example.assignment3.PokemonGymInformation


//I got the idea of using Image Coil to show the image from this video: https://www.youtube.com/watch?v=pbcAVtqZ8bg
@Composable
fun DetailsScreen(sentInIndex:String, modifier:Modifier) {

    val localPokemonList = LocalPokemonList.current

    //Converting the value of the index from String to Int to call the right index.
    val indexNumber = sentInIndex.toInt()

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


            Text(text = "Gym Name: " + localPokemonList[indexNumber].gymName,
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

            Text(text ="Gym Leader: " + localPokemonList[indexNumber].gymLeader,
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

            BuildingTheCoilImage(localPokemonList[indexNumber].gymImageUrl)

        }

    }
}

