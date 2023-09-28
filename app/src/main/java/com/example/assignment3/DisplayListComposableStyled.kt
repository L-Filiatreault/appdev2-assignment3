package com.example.assignment3


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * This function is for displaying the list items in a stylish manner, on Card composables, which are elevated and give a shadow effect.
 * The parameter contains each item in the pokemonGymList.
 * The items are displayed in a colour different than the other background or colours on the app so it stands out in a big way on the screen.
 *
 */
@Composable
fun DisplayListComposableStyled(item: String){

    //Chose a card since it looks better than the Box
    //Learned a few styling tips for the shadow and elevation from the Android developer site: https://developer.android.com/jetpack/compose/components/card
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(topStart = 10.dp,bottomEnd = 10.dp), //Making the top-right and bottom-left corners sharp, and rounding the top-left and bottom-right corners
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ), //This gives a slight shadow to the area below the card
    )
    {
        //Aligning the text items inside to be more uniform-like
        Column(
            modifier = Modifier
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = item,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.labelSmall, //Chose this font since it looks bold and stands out in a good way
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

    }

}