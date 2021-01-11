// Matt Ward B00671544
// Mobile Computing CSCI 4176 Autumn 2020
// Archive Fragment: Users can choose to archive their posts or notes, moving them to a archive section that will organize them accordingly

package com.example.divvy.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.divvy.R
import kotlinx.android.synthetic.main.fragment_archive.*
import kotlinx.android.synthetic.main.fragment_home.*


class ArchiveFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_archive, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate from Archive to HOME

        archive_to_home.setOnClickListener {
            val archivetohomeuseraction = ArchiveFragmentDirections.archivetousermenunav()
            Navigation.findNavController(it).navigate(archivetohomeuseraction)
        }

        // Navigate from Archive to User Menu

        archive_to_menu.setOnClickListener {
            val action = ArchiveFragmentDirections.archivetousermenunav()
            Navigation.findNavController(it).navigate(action)
        }



    }

}