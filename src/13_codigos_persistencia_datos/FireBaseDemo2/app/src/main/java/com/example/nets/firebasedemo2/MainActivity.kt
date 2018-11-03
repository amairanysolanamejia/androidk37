package com.example.nets.firebasedemo2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import android.widget.Toast
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import android.support.v4.app.FragmentActivity
import android.R.attr.password
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    private lateinit var emailTextField: EditText
    private lateinit var passwordTextField: EditText
    private lateinit var signInButton: Button
    private lateinit var signOutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailTextField = findViewById(R.id.et_email)
        passwordTextField = findViewById(R.id.et_password)
        signInButton = findViewById(R.id.button_sign_in)
        signOutButton= findViewById(R.id.button_sign_out)

        mAuth = FirebaseAuth.getInstance()

        signInButton.setOnClickListener {
            signIn(emailTextField.text.toString(),passwordTextField.text.toString())
        }
        signOutButton.setOnClickListener{
            signOut()
        }

    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth.getCurrentUser()
    }


    private fun signIn(email: String, password: String) {
        Log.d(TAG, "signIn:$email")

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "signInWithEmail:success")
                        val user = mAuth.currentUser
                        Toast.makeText(baseContext, "User signed in",
                                Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, AddToDB::class.java)
                        startActivity(intent)
                    } else {
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Log.d(TAG, "signIn:$email $password")
                        Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                    }
                }
    }

    private fun signOut() {
        mAuth.signOut()
        Toast.makeText(baseContext, "Signing out ...",
                Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}
