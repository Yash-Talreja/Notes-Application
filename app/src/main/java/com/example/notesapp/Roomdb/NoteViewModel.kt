package com.example.notesapp.Roomdb

import androidx.compose.foundation.text2.input.delete
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//ViewModel store and manage Ui related data


class NoteViewModel(private val repository: NotesRepository) : ViewModel() {


    val allNotes: LiveData<List<Note>> = repository.allnotes

    fun insert(note: Note)=
        viewModelScope.launch {
            repository.insertNote(note)
        }

    fun delete(noteId: Int) = viewModelScope.launch {
        repository.deleteNote(noteId)
    }




    }