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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    val navController = LocalNavController.current;

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
                .height(200.dp)
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
                containerColor = MaterialTheme.colorScheme.onPrimary
            )
        )
        {
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onPrimaryContainer, //I got this idea from our slides
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

            )
        }




    }

}