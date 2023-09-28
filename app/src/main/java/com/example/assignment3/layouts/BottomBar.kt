package com.example.assignment3.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BottomBar()
{
    //val navController = LocalNavController.current;

    BottomAppBar(
        actions = {
            IconButton(onClick = {/*navController.navigate("MainScreenRoute")*/}) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Go Home"
                )
            }
            IconButton(onClick = {/*
                            navController.navigate("InformationScreenRoute")*/}) {
                Icon(
                    imageVector = Icons.Filled.Create,
                    contentDescription = "Go to Details")
            }
            IconButton(onClick = {/*
                            navController.navigate("ListScreenRoute")*/}) {
                Icon(
                    imageVector = Icons.Filled.List,
                    contentDescription = "Go to List")
            }

        },
        containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
        contentColor = Color.Black



    )


}