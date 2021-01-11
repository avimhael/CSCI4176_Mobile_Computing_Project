package com.example.divvy.notemodel

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query


@Dao
public interface NoteDao {

    @Insert
    suspend fun insertAll(vararg note: Notes): List<Long>

    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<Notes>>

//    @Delete
//    suspend fun deleteNote(vararg note: Notes): List<Long>


    // suspend fun getAllNotes(): List<Notes>

//    @Query("SELECT * FROM notes WHERE note_id = :noteID")
//    suspend fun getNote(noteID: com.example.divvy.notemodel.Notes): Notes

//    @Query("DELETE FROM notes")
//    suspend fun deleteAllNotes(note: com.example.divvy.notemodel.Notes)

}

//class NoteDaoImpl: NoteDao {
//    override suspend fun insertAll(vararg note: Notes): List<Long> {
//
//    }
//
//    override suspend fun getAllNotes(): List<Notes> {
//
//    }
//
//    override suspend fun getNote(noteID: Int): Notes {
//
//    }
//
//    override suspend fun deleteAllNotes() {
//
//    }
//
//}