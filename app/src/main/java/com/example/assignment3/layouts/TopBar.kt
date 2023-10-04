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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar()
{    val navController = LocalNavController.current


    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    var title by rememberSaveable{ mutableStateOf("Pokemon Gyms") };

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            titleContentColor = Color.Black,

            ),
        title = {
            Text(
                text= title,
                style = MaterialTheme.typography.titleLarge //Changed the styling here to make the title stand out
            )
        },
        navigationIcon = {
            IconButton(onClick =
            {
                navController.navigateUp()
            }
            ) {

                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Go Back"
                )
            }
        },
        actions = {
            Row()
            {
                IconButton(
                    onClick = {
                        navController.navigate(Routes.Information.route)}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Go to Information"
                    )
                }
            }

        },
        scrollBehavior = scrollBehavior,
        )

}