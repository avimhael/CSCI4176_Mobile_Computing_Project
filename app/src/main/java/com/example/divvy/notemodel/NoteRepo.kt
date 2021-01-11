package com.example.divvy.notemodel

class NoteRepo(private val dao: NoteDao) {

    val notes = dao.getAllNotes()

    suspend fun insert(note: Notes) {
        dao.insertAll(note)
    }

//    suspend fun delete(note: Notes) {
//        dao.deleteNote(note)
//    }
//
//    suspend fun deleteAll(note: Notes) {
//        dao.deleteAllNotes(note)
//    }
//
//    suspend fun getOne(note: Notes) {
//        dao.getNote(note)
//    }














}