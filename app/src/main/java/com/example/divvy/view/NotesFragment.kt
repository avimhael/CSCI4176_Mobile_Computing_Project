// Matt Ward B00671544
// Mobile Computing CSCI 4176 Autumn 2020
// Notes Fragment: Users will be able to view notes posted by other people using the application.

package com.example.divvy.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.divvy.R
import com.example.divvy.databinding.FragmentNotecreationBinding
import com.example.divvy.databinding.FragmentNotesBinding
import com.example.divvy.notemodel.NoteDatabase
import com.example.divvy.notemodel.NoteRepo
import com.example.divvy.notemodel.Notes
import com.example.divvy.viewmodel.ListViewModel
import com.example.divvy.viewmodel.NotesVMFactory
import kotlinx.android.synthetic.main.fragment_notes.*


class NotesFragment : Fragment() {
    private lateinit var binding: FragmentNotesBinding
    private lateinit var noteViewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_notes)
        val dao = NoteDatabase.getInstance(requireActivity().application).noteDao()
        val repository = NoteRepo(dao)
        val factory = NotesVMFactory(repository)
        noteViewModel = ViewModelProvider(this, factory).get(ListViewModel::class.java)
        binding.viewmodel = noteViewModel
        binding.lifecycleOwner = this
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.ViewNotes.layoutManager = LinearLayoutManager(requireContext())
        displayNoteList()


    }

    private fun displayNoteList() {
        noteViewModel.notes.observe(this, Observer {
            Log.i("MYTAG", it.toString())
            binding.ViewNotes.adapter = NotesListAdapter(it)
        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //navCorrectly()

        // Navigate from Notes to HOME

        notes_to_home.setOnClickListener {
            val notestohomeuseraction = NotesFragmentDirections.notestohome()
            Navigation.findNavController(it).navigate(notestohomeuseraction)
        }

        // Navigate from Notes to Create Note

        createnoteFrag.setOnClickListener {
            val action1 = NotesFragmentDirections.notestonotecreation()
            Navigation.findNavController(it).navigate(action1)
        }

        // Navigate from Notes to User Menu

        notes_to_menu.setOnClickListener {
            val action = NotesFragmentDirections.notestousermenunav()
            Navigation.findNavController(it).navigate(action)
        }

    }
}
