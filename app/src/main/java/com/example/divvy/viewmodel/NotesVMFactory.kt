package com.example.divvy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.divvy.notemodel.NoteRepo
import java.lang.IllegalArgumentException

class NotesVMFactory(private val repo: NoteRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)){
            return ListViewModel(repo) as T
            }
            throw IllegalArgumentException("Unknown View Model class")
    }


}