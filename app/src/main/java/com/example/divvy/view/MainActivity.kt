// Matt Ward B00671544
// Mobile Computing CSCI 4176 Autumn 2020
// Main Activity: The first page people see if users are not registered or logged in. Activity will give users a choice to do these two options.

package com.example.divvy.view


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.divvy.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance();

        // Functionality for login button - if fields are not empty, log a user in. if they are, display a message

        loginbutton.setOnClickListener {

            if(login_password.text.trim().isNotEmpty() && login_email.text.trim().isNotEmpty()) {
                SignInUser()
            } else {
                Toast.makeText (this, "Please input an email address and password!", Toast.LENGTH_LONG).show()
            }


        }

        // Button that sends the user to the registration page instead

        registermainbutton.setOnClickListener {
            val intent = Intent (this,RegisterActivity::class.java);
            startActivity(intent)
        }


    }

        // function to sign a user in via email and password with Firebase. If successful, allows user to move to the app's main page. If it fails, displays an error

    fun SignInUser() {

        auth.signInWithEmailAndPassword(login_email.text.trim().toString(), login_password.text.trim().toString()).addOnCompleteListener (this) {
                task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, HomeActivity::class.java);
                    startActivity(intent)}
                else {
                    Toast.makeText(this, "Auth Error " + task.exception, Toast.LENGTH_LONG).show()
                }
            }
    }

        // When the system enters the started state, this callback is invoked. Checks for authentication

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser;
        if (user != null) {
            val intent = Intent(this, HomeActivity::class.java);
            startActivity(intent)
        } else {
            Toast.makeText(this, "Welcome to Divvy!", Toast.LENGTH_LONG).show()
        }
    }



}