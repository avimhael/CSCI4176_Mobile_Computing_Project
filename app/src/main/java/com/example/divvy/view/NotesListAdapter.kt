package com.example.divvy.view

import android.app.assist.AssistStructure
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.divvy.R
import com.example.divvy.databinding.ItemNoteBinding
import com.example.divvy.notemodel.Notes
import kotlinx.android.synthetic.main.item_note.view.*

class NotesListAdapter (private val notesList: List<Notes>):
    RecyclerView.Adapter<NotesListAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemNoteBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_note, parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notesList[position])
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(notes: Notes) {
            binding.authorTextView.text = notes.author
            binding.dateCreatedTextView.text = notes.dateCreated
            binding.keepUntilTextView.text = notes.dateKeepUntil
            binding.messageBodyTextView.text = notes.messageBody
        }
    }
}












