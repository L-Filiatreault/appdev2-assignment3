package com.example.assignment3.layouts

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar()
{
    //val navController = LocalNavController.current;
    CenterAlignedTopAppBar(title = { Text("Pokemon Gym App") },
        navigationIcon = {
            IconButton(onClick = { /*navController.navigateUp()*/}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Go Back"
                )
            }
        },
        actions = {
            Row()
            {
                IconButton(onClick = { /*navController.navigate("Register/Login"*/}) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "Login"
                    )
                }

                IconButton(onClick = { /*navController.navigate("Register/Signup")*/}) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Signup"
                    )
                }
            }

        },
    )

}