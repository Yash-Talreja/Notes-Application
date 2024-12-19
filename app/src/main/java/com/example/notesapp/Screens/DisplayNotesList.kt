package com.example.notesapp.Screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.Roomdb.Note
import com.example.notesapp.Roomdb.NoteViewModel

@Composable
fun DisplayNoteslist(
    notes: List<Note>,
    viewModel: NoteViewModel
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().padding(20.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(notes) { note ->
            NoteListItem(
                note = note,
                viewModel = viewModel,
                onDelete = {
                    // Optional: You can add any additional logic here
                    // that should happen after deleting a note
                }
            )
        }
    }
}