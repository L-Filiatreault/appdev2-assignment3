package com.example.assignment3.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment3.LocalNavController
import com.example.assignment3.LocalPokemonList
import com.example.assignment3.SupportingFiles.Routes
import com.example.assignment3.SupportingFiles.DisplayListComposableStyled


/**
 * The composable function ListScreen will help display the items added into the updated pokemonGymList
 * in a cohesive manner. The user will be able to select a single item on the list that will bring them to the
 * Details screen to show more information about the particular item in the list. As well the user can delete certain
 * items from the list should they no longer want that item.
 */
@Composable
fun ListScreen(modifier:Modifier) {

    val pokemonListCurrent = LocalPokemonList.current //Keeping a link to the list in the app so items rendered from the list are current
    var selectedIndex by rememberSaveable { mutableStateOf("") } //selectedIndex allows to retrieve the item selected in the list to be displayed on Details screen
    val navController = LocalNavController.current //This will help navigate to the Details screen in case the user wants to look further at an item's information

    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.surfaceTint),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onSecondary
        )
    ) {
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "Click on the item in the list to view details\nOr click on the 'X' to remove it from the list",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            letterSpacing = 0.1.sp,
            lineHeight = 30.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        LazyColumn(modifier = Modifier.height(500.dp))
        {
            //Going through the list items one-by-one, and sending them to the DisplayListComposableStyled() function to present them better.
            //As well if the user clicks on a list item it will send them to the Details screen to look at that particular item.
            //Or if the user doesn't want an item anymore on their list they can click on the X on the left hand side of the item and cause the
            //item to be removed from the list
            items(pokemonListCurrent) { item ->


                Row(modifier = Modifier.padding(10.dp)
                    .clickable {

                        //If a particular item is clicked on the card itself then the screens swap immediately to the Details screen, displaying information about that item
                        selectedIndex = pokemonListCurrent.indexOf(item).toString()
                        navController.navigate(Routes.Details.go(selectedIndex))
                    }
                )
                {
                    //When a particular item no longer is needed then it can be removed from the list and the list will be updated immeadiately
                    //https://developer.android.com/guide/navigation/backstack
                    IconButton(
                        onClick = {
                            selectedIndex = pokemonListCurrent.indexOf(item).toString()
                            pokemonListCurrent.remove(item)
                            navController.popBackStack(Routes.Details.go(selectedIndex), inclusive = true)
                        }
                    )
                    {
                        Icon(Icons.Filled.Close, contentDescription="Remove Gym Item")
                    }
                    //Calling the function composable to display items in the list in a pleasing-manner
                    DisplayListComposableStyled(item)
                }
            }

        }
    }
}