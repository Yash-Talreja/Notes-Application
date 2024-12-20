package com.example.notesapp.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesapp.R
import com.example.notesapp.Roomdb.Note
import com.example.notesapp.Roomdb.NoteViewModel

@Composable
fun NoteListItem(note: Note,viewModel: NoteViewModel,  onDelete: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(12.dp), colors = CardDefaults.cardColors(
            containerColor = Color(note.color)
        ),

        border = BorderStroke(2.dp, color = Color.Black),
        modifier = Modifier.padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
        ) {
            Text(text = "${note.title}", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(6.dp))

            Text(text = "${note.description}", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.White)


            Spacer(modifier = Modifier.height(2.dp))

            IconButton(
                onClick = {
                    viewModel.delete(note.id)
                    onDelete()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete Note"
                )
            }



        }
    }
}