package com.example.divvy.viewmodel

import android.app.Application
import android.view.View
import android.view.View.VISIBLE
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.divvy.notemodel.NoteDao
import com.example.divvy.notemodel.NoteDatabase
import com.example.divvy.notemodel.NoteRepo
import com.example.divvy.notemodel.Notes
import com.example.divvy.utils.Event
import kotlinx.coroutines.Job
//import com.example.divvy.utils.SharedPreferencesHelper
import kotlinx.coroutines.launch


class ListViewModel(private val repository: NoteRepo) : ViewModel(),Observable {

    val notes = repository.notes
    private val _navigateToDetails = MutableLiveData<Event<String>>()

    @Bindable
    val author = MutableLiveData<String>()
    @Bindable
    val dateCreated = MutableLiveData<String>()
    @Bindable
    val keepUntil = MutableLiveData<String>()
    @Bindable
    val messageBody = MutableLiveData<String>()
    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()
    @Bindable var noteVisibility = MutableLiveData<Int>()
              var currentVisibility: Int = noteVisibility.value?:0

    //@Bindable val clearAllorDeleteButtonText = MutableLiveData<String>()
    @Bindable
    val submitButtonText = MutableLiveData<String>()

    init {
        author.value = "Generic Author"
        dateCreated.value = "01/01/1999"
        keepUntil.value = "01/01/2021"
        messageBody.value = "foobar"
        saveOrUpdateButtonText.value = "View Notes"
        submitButtonText.value = "Submit Note"
    }

    fun submitData() {
        val name = author.value?:"Generic Author"
        val dateCreatedOn = dateCreated.value?:"01/01/1999"
        val dateKeepUntil = keepUntil.value?:"01/01/2021"
        val noteMessage = messageBody.value?:"foobar"
        insert(Notes(0, name, dateCreatedOn,dateKeepUntil,noteMessage))
        author.value = null
        dateCreated.value = null
        keepUntil.value = null
        messageBody.value = null

    }



    val navigateToDetails : LiveData<Event<String>>
        get() = _navigateToDetails


    fun userClicksOnButton(itemId: String) {
        _navigateToDetails.value = Event(itemId)  // Trigger the event by setting a new Event as a new value
    }


    fun makeNotesVisible() {
        currentVisibility = noteVisibility.value ?: 0
        if (currentVisibility == View.GONE) {
            noteVisibility.value = View.VISIBLE
        }
    }

    fun clearAllOrDelete() {


    }

    fun insert(notes: Notes) : Job = viewModelScope.launch {
        repository.insert(notes)
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}