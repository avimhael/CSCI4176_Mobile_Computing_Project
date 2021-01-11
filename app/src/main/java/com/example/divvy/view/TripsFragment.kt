// Matt Ward B00671544
// Mobile Computing CSCI 4176 Autumn 2020
// Trips Fragment:  Users will be able to view trips posted by other people using the application.

package com.example.divvy.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.divvy.R
import kotlinx.android.synthetic.main.fragment_archive.*
import kotlinx.android.synthetic.main.fragment_bookmarked_trips.*
import kotlinx.android.synthetic.main.fragment_trips.*

class TripsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trips, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate from Trips to HOME


        trips_to_home.setOnClickListener {
            val tripstohomeuseraction = TripsFragmentDirections.tripstohome()
            Navigation.findNavController(it).navigate(tripstohomeuseraction)
        }

        // Navigate from Trips to User Menu

        trips_to_menu.setOnClickListener {
            val action = TripsFragmentDirections.tripstousermenunav()
            Navigation.findNavController(it).navigate(action)
        }
    }
}