package com.example.assignment3.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.assignment3.LocalPokemonList

/**
 * The Details Composable takes data inside the PokemonGymInformation data class and displays it to the user
 * in a larger and more detailed format. It will display the text information of the Gym Name and Gym Leader Name, and provide
 * an image from the image url link.
 * This screen is primarily responsible for showing the information of the user's input.
 * @param sentInIndex : This sends the String value of the index which will be converted into an Int so as to access that particular object from the correct index in the pokemonGymList
 * @param modifier: This is the modifier to display the composables in a decorated way
 */
@Composable
fun DetailsScreen(sentInIndex:String, modifier:Modifier) {

    val localPokemonList = LocalPokemonList.current //Providing the updated list here to retrieve up-to-date objects inside

    //Converting the value of the index from String to Int to call the right index.
    val indexNumber = sentInIndex.toInt()

    Card(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(16.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.surfaceTint),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onSecondary
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


            Spacer(modifier = Modifier.padding(5.dp))

            //Indicating to the user what this screen is used for
            Text(
                text= "Details about gym",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.padding(20.dp))

            //Displaying the Gym Name information in a clear and pleasant way to the user
            Text(text = "Gym Name: " + localPokemonList[indexNumber].gymName,
                modifier = Modifier.padding(4.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    letterSpacing = 0.1.sp,
                    lineHeight = 30.sp
                )
            )
            Spacer(modifier = Modifier.padding(20.dp))

            //Displaying the Gym Leader information in a clear and pleasant way to the user
            Text(text ="Gym Leader: " + localPokemonList[indexNumber].gymLeader,
                modifier = Modifier.padding(4.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    letterSpacing = 0.1.sp,
                    lineHeight = 30.sp
                )
            )
            Spacer(modifier = Modifier.padding(20.dp))

            //Displaying the Gym image information to indicate what gym they are staring at currently
            Text(text = localPokemonList[indexNumber].gymName+ " Gym Image: ",
                modifier = Modifier.padding(4.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    letterSpacing = 0.1.sp,
                    lineHeight = 30.sp
                )
            )

            //Using a Box to display the image
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .clip(RectangleShape)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            {
                //Using rememberImagePainter so the image doesn't break when rotating the screen, the data renders the image located in the URL
                val painter = rememberImagePainter(
                    data = localPokemonList[indexNumber].gymImageUrl)

                //Displaying the image given by the painter
                Image(
                    painter = painter,
                    contentDescription = "An image of a pokemon gym"
                )

            }

        }

    }
}

