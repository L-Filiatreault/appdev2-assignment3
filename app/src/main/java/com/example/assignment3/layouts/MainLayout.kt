package com.example.assignment3.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(
    content:@Composable ()-> Unit
)
{
    //val navController = LocalNavController.current

    Scaffold(
        topBar =
        {
            TopBar()
        },
        bottomBar =
        {
            BottomBar()
        }
    )

    {
        Column(modifier = Modifier.padding(it))
        {
                content()
        }
    }
}