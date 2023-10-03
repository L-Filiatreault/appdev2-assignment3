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
import com.example.assignment3.Routes

@Composable
fun ListScreen(modifier:Modifier) {
    val pokemonListCurrent = LocalPokemonList.current
    var selectedIndex by rememberSaveable { mutableStateOf("") }
    val navController = LocalNavController.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.surfaceTint),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onTertiary
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
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.padding(6.dp))
        LazyColumn(modifier = Modifier.height(400.dp))
        {
            //Going through the list items one-by-one, and sending them to the DisplayListComposableStyled() function.
            //As well if the user clicks on a list item it will delete that item from the list and therefore the screen itself.
            items(pokemonListCurrent) { item ->
                Row(modifier = Modifier.padding(10.dp)
                    .clickable {
                        selectedIndex = pokemonListCurrent.indexOf(item).toString()
                        navController.navigate(Routes.Details.go(selectedIndex))
                    }
                )
                {
                    IconButton(
                        onClick = { pokemonListCurrent.remove(item) }
                    )
                    {
                        Icon(Icons.Filled.Close, contentDescription="Remove Gym Item")
                    }
                    DisplayListComposableStyled(item)
                }
            }

        }
    }
}