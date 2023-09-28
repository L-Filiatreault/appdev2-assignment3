package com.example.assignment3.layouts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

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
                Icon(Icons.Filled.Info, contentDescription = "Go to Information")
            }
            IconButton(onClick = {/*
                navController.navigate("ListScreenRoute")*/}) {
                Icon(Icons.Filled.Phone, contentDescription = "Go to List")
            }
        })


}