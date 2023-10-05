package com.example.assignment3.SupportingFiles


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.assignment3.LocalNavController
import com.example.assignment3.LocalPokemonList
import com.example.assignment3.PokemonGymInformation


/**
 * This Composable function allows all user input from the text forms to be added to the pokemonGymList.
 * The objective of this function is taking input from the user to fill out which gyms they have completed, and not input empty fields into the
 * list. As well it uses a rememberSaveable to restore items on the screen in case the screen was rotated and the component remembers the value inputted.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGymForm() {


    val pokemonListCurrent = LocalPokemonList.current //Retrieving the pokemonGymList with the Provider pattern so information can be added instantly
    val navController = LocalNavController.current //This is used here so the Details screen will be navigated to next after the user has clicked on the button "Add Gym to list"


    var selectedIndex by rememberSaveable { mutableStateOf("") } //This will store the value of the index to help render the Details page to the currently-added pokemonGymList item
    var gymNameValue by rememberSaveable { mutableStateOf("") } //This will keep the value the user inputted when the screen is rotated
    var gymLeaderValue by rememberSaveable { mutableStateOf("") } //This will keep the value the user inputted when the screen is rotated
    var gymBuildingURL by rememberSaveable { mutableStateOf("") } //This will keep the value the user inputted when the screen is rotated


    //Setting things inside a column to make it appear ordered
    Column( modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.padding(25.dp))

        //Descriptive text to show the user what to do in case they don't know what the screen is used for primarily
        Text(text = "Welcome to the Pokemon Gym App" +
                "\nThis app records all the gyms visited" +
                "\nPlease fill out all fields below",
            style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.padding(8.dp))

        //Adding a row to store an icon beside the different text fields so it can differentiate each input to the user
        //Make it easier for the user to know what's the next value to be inputted
        //In this case the user is inputting the pokemon gym they visited

        Row()
        {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Outlined.Home, contentDescription = "Pokemon Gym", modifier = Modifier.size(24.dp))
            }
            TextField(
                value = gymNameValue,
                onValueChange = { gymNameValue = it},
                textStyle = TextStyle(textAlign = TextAlign.Left),
                label = {Text(text = "Enter Gym Name: ")},

                )
        }

        Spacer(modifier = Modifier.padding(5.dp))

        //Adding a row to store an icon beside the different text fields so it can differentiate each input to the user
        //Make it easier for the user to know what's the next value to be inputted
        //In this case the user is inputting the gym leader
        Row()
        {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Outlined.Face, contentDescription = "Pokemon Gym Leader", modifier = Modifier.size(24.dp))
            }
            TextField(
                value = gymLeaderValue,
                onValueChange = { gymLeaderValue = it},
                textStyle = TextStyle(textAlign = TextAlign.Left),
                label = {Text(text = "Enter Gym Leader Name: ")}
            )
        }

        Spacer(modifier = Modifier.padding(5.dp))

        //Adding a row to store an icon beside the different text fields so it can differentiate each input to the user
       //This indicates to the user to paste in the link to an image url that will be stored in the pokemonGymList and then display the image later on
        Row()
        {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Outlined.AccountBox,
                    contentDescription = "Gym Location Image URL",
                    modifier = Modifier.size(24.dp)
                )
            }
            TextField(
                value = gymBuildingURL,
                onValueChange = { gymBuildingURL = it },
                textStyle = TextStyle(textAlign = TextAlign.Left),
                label = { Text(text = "Enter Gym Image URL: ") }
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        //When the user clicks on the button a series of events will take place. The fields will be evaluated to make sure they're not containing
        //empty data so to prevent null values being entered. As well the information from the text fields will
        //be added to the data class PokemonGymInformation to create a new data object to be read from, and then it's stored in the pokemonGymList.
        //The next screen navigated to is the Details screen, so as to show the user what information they have entered.
        Button(
            onClick = {
                if(gymNameValue.isNotBlank() && gymLeaderValue.isNotBlank() && gymBuildingURL.isNotBlank())
                {
                    var newPokemonGymObject = PokemonGymInformation(gymNameValue, gymLeaderValue, gymBuildingURL)

                    //Adding the new object to the pokemonGymList so it can be displayed in the list and Details
                    pokemonListCurrent.add(newPokemonGymObject);

                    //Added a way to extract the latest index number from the list and use that index number to send to our Details screen
                    //Converting it to string since it's the only way the value is stored inside of our Route string and can be read properly
                    selectedIndex = pokemonListCurrent.indexOf(newPokemonGymObject).toString()

                    //Routing to the Details page from here so the user can see the details of what they've entered
                    navController.navigate(Routes.Details.go(selectedIndex))

                    //Resetting the values of the text fields to empty after the user inputs
                    gymNameValue = "";
                    gymLeaderValue = "";
                    gymBuildingURL="";
                }
                else
                {
                    Error("All fields must be entered!!!")
                }

            },
            colors =  ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer, //Using a bright bold colour to attract the user to click on the button
                contentColor = MaterialTheme.colorScheme.onSecondary
            )

        ) {
            Text("Add Gym to list",
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}