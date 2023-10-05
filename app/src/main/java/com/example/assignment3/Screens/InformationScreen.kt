package com.example.assignment3.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment3.R

/***
 * The Information Screen function composable displays information about what the app is supposed to
 * be used for to the user. It displays the mission of the app to the user alongside some nice images.
 */
@Composable
fun InformationScreen(modifier: Modifier)
{
    Column(
        modifier = modifier
            .fillMaxSize()
            .fillMaxWidth()
            .verticalScroll(
                state = rememberScrollState()
            )
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        {
            //Used a large image at the top along with the text to give an impressive appearance for the Information page
            //This image is credited to Vincent M.A. Janssen, and was taken from here: https://www.pexels.com/photo/person-holding-pokemon-ball-toy-1310847/
            val imagePainter = painterResource(id = R.drawable.pokeball)
            Image(
                painter = imagePainter,
                contentDescription ="An image of Pokeball",
                modifier = modifier.fillMaxSize()

            )
            Text(text = "Information",
                style = TextStyle(
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White.copy(alpha=0.75f), //I got this idea from our slides
                    letterSpacing = 0.1.sp,
                    lineHeight = 30.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)

            )
        }


        //This displays the text about what the app is used for in an aesthetically-pleasing manner
        Card(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.surfaceTint),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black.copy(alpha=0.5f)
            )
        )
        {
            Text(text = "We are devoted Pokemon fans who want to help Pokemon trainers record the gyms they have visited. This app takes input from the user " +
                    "to display the Pokemon gym location, the gym leader and an image of the gym. It will contain a list of all the different gyms visited" +
                    " as well display the details of each gym visited.",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(16.dp))
        }
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = modifier
                .fillMaxSize()
        )
        {
            //This image is credited to Carolina Castilla Arias, and was taken from here: https://www.pexels.com/photo/close-up-photo-of-pokemon-pikachu-figurine-1716861/
            val imagePainter = painterResource(id = R.drawable.detectivepikachu)
            Image(
                painter = imagePainter,
                contentDescription ="Detective Pikachu image",
                modifier = modifier.fillMaxSize()
            )
        }
    }
}