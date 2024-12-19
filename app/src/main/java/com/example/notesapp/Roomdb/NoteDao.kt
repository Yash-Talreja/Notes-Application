package com.example.notesapp.Roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    //suspended fun use in couroutine to perform
    //asynchronus code without blocking main thread

    @Insert
    suspend fun insert(note: Note)


    @Query("SELECT * FROM notes_table")
    fun getallNotes():LiveData<List<Note>>

    @Query("DELETE FROM notes_table WHERE id = :noteId")
    suspend fun deleteNote(noteId: Int)



}