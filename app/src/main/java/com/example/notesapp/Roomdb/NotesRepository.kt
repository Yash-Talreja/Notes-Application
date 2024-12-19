package com.example.notesapp.Roomdb

import androidx.lifecycle.LiveData

//fetching Data From The Network
//loading data from local database

class NotesRepository(private val notesDao:NoteDao) {

    val allnotes :LiveData<List<Note>> = notesDao.getallNotes()

    suspend fun insertNote(note: Note)
    {
        return notesDao.insert(note)
    }


    suspend fun deleteNote(noteId: Int) {
        notesDao.deleteNote(noteId)
    }



}