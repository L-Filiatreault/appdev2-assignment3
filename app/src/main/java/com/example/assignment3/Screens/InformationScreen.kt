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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment3.LocalNavController
import com.example.assignment3.R
import com.example.assignment3.rememberMutableStateListOf

@Composable
fun InformationScreen(modifier: Modifier)
{
    //I got this idea from here: https://developer.android.com/jetpack/compose/text/user-input#style-input
        val rainbowColors: List<Color> = listOf( Color.Yellow,
            Color.Green, Color.Cyan, Color.Blue)
        val brush = remember {
            Brush.linearGradient(
                colors = rainbowColors
            )
        }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 10.dp)
            .verticalScroll(
                state = rememberScrollState()
            )
            .background(color = MaterialTheme.colorScheme.onTertiary)
    ){

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        {
            val imagePainter = painterResource(id = R.drawable.pokeball)
            Image(
                painter = imagePainter,
                contentDescription ="An image of Pokeball",
                modifier = modifier
                    .fillMaxWidth()
                    .height(200.dp)

            )
            Text(text = "About Us",
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


            Text(text = "We are devoted Pokemon fans who want to help would-be trainers record the gyms they have visited. This app takes input from the user " +
                    "to display the Pokemon gym location, the gym leader and an image of the gym. It will contain a list of all the different gyms visited" +
                    " as well display the details of each gym visited.",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    brush = brush,
                    letterSpacing = 0.1.sp,
                    lineHeight = 30.sp
                ),
                modifier = Modifier
                    .padding(16.dp))
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        {
            val imagePainter = painterResource(id = R.drawable.detectivepikachu)
            Image(
                painter = imagePainter,
                contentDescription ="Detective Pikachu image",
                modifier = modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }

}