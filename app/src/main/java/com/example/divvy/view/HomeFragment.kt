package com.example.divvy.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.divvy.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {



    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate from HOME to User Menu

        home_to_menu.setOnClickListener {
            val hometousermenuaction = HomeFragmentDirections.hometousermenu()
            Navigation.findNavController(it).navigate(hometousermenuaction)
        }

        hometonotesFrag.setOnClickListener {
            val hometonotesaction = HomeFragmentDirections.hometonotes()
            Navigation.findNavController(it).navigate(hometonotesaction)
        }

        hometotripsFrag.setOnClickListener {
            val hometotripsaction = HomeFragmentDirections.hometotrips()
            Navigation.findNavController(it).navigate(hometotripsaction)
        }
    }
    }
