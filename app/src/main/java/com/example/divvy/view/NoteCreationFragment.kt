// Matt Ward B00671544
// Mobile Computing CSCI 4176 Autumn 2020
// Notes Fragment: Users will be able to view notes posted by other people using the application.

package com.example.divvy.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.divvy.R
import com.example.divvy.databinding.FragmentNotecreationBinding
import com.example.divvy.notemodel.NoteDatabase
import com.example.divvy.notemodel.NoteRepo
import com.example.divvy.viewmodel.ListViewModel
import com.example.divvy.viewmodel.NotesVMFactory
import kotlinx.android.synthetic.main.fragment_archive.*
import kotlinx.android.synthetic.main.fragment_bookmarked_trips.*
import kotlinx.android.synthetic.main.fragment_notecreation.*
import kotlinx.android.synthetic.main.fragment_notes.*

class NoteCreationFragment : Fragment() {
    private lateinit var binding: FragmentNotecreationBinding
    private lateinit var noteViewModel: ListViewModel
//
//    fun onCreateView(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)

        //displayNoteList()

//    }

//    private fun displayNoteList() {
//        noteViewModel.notes.observe(this, Observer {
//            Log.i("MYTAG",it.toString())
//        })
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.setContentView(requireActivity(),R.layout.fragment_notecreation)
        val dao = NoteDatabase.getInstance(requireActivity().application).noteDao()
        val repository = NoteRepo(dao)
        val factory = NotesVMFactory(repository)
        noteViewModel = ViewModelProvider(this,factory).get(ListViewModel::class.java)
        binding.viewmodel = noteViewModel
        binding.lifecycleOwner = this
        return inflater.inflate(R.layout.fragment_notecreation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate from Note Creation to HOME

        notecreationtohomeimg.setOnClickListener {
            val notecreationtohomeuseraction = NoteCreationFragmentDirections.notecreationtohome()
            Navigation.findNavController(it).navigate(notecreationtohomeuseraction)
        }

        // Navigate from Note Creation to User Menu

        notecreationtousermenu.setOnClickListener {
            val notecreationtomenuaction = NoteCreationFragmentDirections.notecreationtousermenu()
            Navigation.findNavController(it).navigate(notecreationtomenuaction)
        }


    }
}