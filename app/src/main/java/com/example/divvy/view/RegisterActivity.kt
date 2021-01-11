// Matt Ward B00671544
// Mobile Computing CSCI 4176 Autumn 2020
// Register Activity: This activty will allow a user to register an account with the application.

package com.example.divvy.view


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.divvy.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*


    class RegisterActivity : AppCompatActivity() {
        private lateinit var auth: FirebaseAuth
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_register)
            auth = FirebaseAuth.getInstance();

            // Functionality for registration button - if fields are not empty, register a user. if they are, display a message

            register_submit_button.setOnClickListener {

                if (registeremailaddress.text.trim().isNotEmpty() || registerpassword.text.trim().isNotEmpty()) {
                   registerUser();
                } else {
                    Toast.makeText(this, "Please enter an email address & password!", Toast.LENGTH_LONG).show()
                }

            }

            // Button that sends the user to the login page instead

            registerloginbutton.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java);
                startActivity(intent);

            }

        }

        // function to register a user in via email and password with Firebase. If successful, allows user to move to the app's main page. If it fails, displays an error

        fun registerUser() {

            auth.createUserWithEmailAndPassword(registeremailaddress.text.trim().toString(), registerpassword.text.trim().toString())
                .addOnCompleteListener (this) {
                        task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Registration successful!",Toast.LENGTH_LONG).show()
                        startActivity(intent)}
                    else {
                        Toast.makeText(this, "Registration failed! " + task.exception, Toast.LENGTH_LONG).show()
                    }
                }
        }

        // When the system enters the started state, this callback is invoked. Checks for authentication. Else writes a message to console log

        override fun onStart() {
            super.onStart()
            val user = auth.currentUser;
            if (user != null) {
                val intent = Intent(this, HomeActivity::class.java);
                startActivity(intent)
            } else {
                Log.e("user_status", "user null")
            }
        }

    }