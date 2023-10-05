package com.example.assignment3.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


/**
 * MainLayout composable allows both the top and bottom navigation bars to render and be accessible across
 * different screens in the app. It ties the app together by giving a consistent look throughout the app.
 * It uses a lambda to accept composable content.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(
    content:@Composable ()-> Unit
)
{

    //Scaffold holds both the TopBar and BottomBar navigation bars, allows to be shared across several screens
    Scaffold(

        //Calling the TopBar Composable here so it will render across different screens
        topBar =
        {
            TopBar()
        },
        //Calling the BottomBar Composable here so it will render across different screens
        bottomBar =
        {
            BottomBar()
        }
    )

    {
        //Displaying the different composable functions here so it can render the different screens.
        Column(modifier = Modifier.padding(it))
        {
            content()
        }
    }
}