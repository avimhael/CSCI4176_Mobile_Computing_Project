// Matt Ward B00671544
// Mobile Computing CSCI 4176 Autumn 2020
// User Menu Fragment:  Users will be able to access information about their account, and view bookmarks and archives

package com.example.divvy.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.divvy.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_user_menu.*


class UserMenuFragment : Fragment() {
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance();

        //Click on user menu logo, redirect to HOME

        usermenulogo.setOnClickListener {
            val usermenutohomeuseraction = UserMenuFragmentDirections.usermenutohome()
            Navigation.findNavController(it).navigate(usermenutohomeuseraction)
        }

        // Navigate to User Archive

        userarchivebutton.setOnClickListener {
            val action = UserMenuFragmentDirections.usermenutoarchivenav()
            Navigation.findNavController(it).navigate(action)
        }

        // Navigate to Bookmarked Notes

        bookmarkednotesbutton.setOnClickListener {
            val action = UserMenuFragmentDirections.usermenutobookmarkednotesnav()
            Navigation.findNavController(it).navigate(action)
        }

        // Logout

        logoutbutton.setOnClickListener {
            auth.signOut()
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Bookmarked Trips

        bookmarkedtripsbutton.setOnClickListener {
            val action = UserMenuFragmentDirections.usermenutobookmarkedtripsnav()
            Navigation.findNavController(it).navigate(action)
        }

        // Navigate to User Settings

        usersettingsbutton.setOnClickListener {
            val action = UserMenuFragmentDirections.usermenutosettingsnav()
            Navigation.findNavController(it).navigate(action)
        }

    }
}