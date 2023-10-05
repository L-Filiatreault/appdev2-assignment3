package com.example.assignment3.layouts

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.assignment3.LocalNavController
import com.example.assignment3.SupportingFiles.Routes


/**
 *
 * The TopBar composable is used to render a navigable top bar across several screens, and to provide access to the Information
 * Screen and the Back button to navigate upwards in the app.
 * It holds the title of the app inside a rememberSaveable so the text doesn't get erased when the screen is rotated.
 * It uses a CenterAlignedTopAppBar because it looks better than small or medium bar sized.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar()
{

    val navController = LocalNavController.current //Using this to access the Information screen's route, and to go back when the user wants to
    var title by rememberSaveable{ mutableStateOf("Pokemon Gyms") }; //Storing the title in a rememberSaveable so it doesn't get erased when the screen is flipped


    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            titleContentColor = Color.Black
            ),
        title = {
            Text(
                text= title,
                style = MaterialTheme.typography.titleLarge //Changed the styling here to make the title stand out in a bigger way
            )
        },
        navigationIcon = {
            IconButton(onClick =
            {
                //Putting this conditional here to prevent an out of list Exception crash
                //When the user can sometimes go back to Details when the item is no longer there a crash could happen, but this will
                //prevent it
                if(navController.navigateUp() != null)
                {
                    navController.navigateUp()
                }
            }
            ) {

                //An icon to display the arrow pointing back to indicate the user they can go back to a previous page
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Go Back"
                )
            }
        },
        actions = {

            Row()
            {
                //This will cause the user to go to the Information Screen when they want to access it
                //The icon is the information vector since it's routing to an information page
                IconButton(
                    onClick = {
                        //Calling the Seal class Routes for the Information page here so the user can be routed instantly
                        navController.navigate(Routes.Information.route)}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Go to Information"
                    )
                }
            }

        }
    )

}