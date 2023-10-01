package com.example.assignment3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

/**
 * This is the build the image sent from an image url. I got the idea from these sites:
 * https://coil-kt.github.io/coil/compose/
 * https://medium.com/geekculture/jetpack-compose-image-loading-using-coil-647a8098c217
 */

@Composable
fun BuildingTheCoilImage(gymImageUrl: String)
{

    Box(modifier = Modifier
        .height(300.dp)
        .width(300.dp))
    {
        val painter = rememberImagePainter(
            data = gymImageUrl)

        Image(
            painter = painter,
            contentDescription = "An image of a pokemon gym"
        )

    }

}