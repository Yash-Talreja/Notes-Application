package com.example.notesapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt

@Composable
fun color(selectedcolor: Color, onselectedcolor: (Color) -> Unit) {
    val colorlist = listOf(
        Color.Blue,
        Color.Cyan,
        Color.Green,
        Color.Magenta,
        Color.Yellow,
        Color.Red,
        Color.Gray,
        Color.LightGray,
        Color.White


    )

    LazyRow(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.padding(8.dp)) {

        items(colorlist){
            Box(modifier = Modifier
                .size(40.dp)
                .padding(4.dp)
                .clip(CircleShape)
                .background(color = it)
                .border(
                    width = if (it == selectedcolor) 4.dp else 0.dp,
                    color = if (it == selectedcolor) Color.Black else Color.Transparent,
                    shape = CircleShape

                )
                .clickable {  onselectedcolor(it)})
        }

    }
}