// Matt Ward B00671544
// Mobile Computing CSCI 4176 Autumn 2020
// Settings Fragment: This fragment will allow users to view and change various information about their account

package com.example.divvy.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.divvy.R
import kotlinx.android.synthetic.main.fragment_bookmarked_trips.*
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate from User Settings to HOME

        settings_to_home.setOnClickListener {
            val settingstohomeuseraction = SettingsFragmentDirections.settingstousermenunav()
            Navigation.findNavController(it).navigate(settingstohomeuseraction)
        }

        // Navigate from User Settings to User Menu

        settings_to_menu.setOnClickListener {
            val action = SettingsFragmentDirections.settingstousermenunav()
            Navigation.findNavController(it).navigate(action)
        }


    }
}