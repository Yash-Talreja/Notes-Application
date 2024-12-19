package com.example.notesapp.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.notesapp.Roomdb.Note
import com.example.notesapp.Roomdb.NoteViewModel

@Composable

fun Displaydialouge(viewModel: NoteViewModel, showDialog: Boolean, onDismiss: () -> Unit) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var selectedcolr by remember {
        mutableStateOf(Color.Blue)
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismiss },
            title = { Text(text = "Enter Note") },
            text = {
                Column {
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text(text = "Note Title") })

                    Spacer(modifier = Modifier.height(10.dp))

                    TextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text(text = "Note Description") })

                    Spacer(modifier = Modifier.height(18.dp))

                    color(
                        selectedcolor = selectedcolr,
                        onselectedcolor = {selectedcolr=it}
                    )

                }
            },
            confirmButton = {
                Button(onClick = {
                    var note = Note(
                        0, title, description, selectedcolr.toArgb()
                    )

                    viewModel.insert(note)


                }) {
                    Text(text = "Save Note")
                }
            },
            dismissButton = {
                Button(onClick = onDismiss)
                {
                    Text(text = "Cancel")
                }
            })
    }
}

