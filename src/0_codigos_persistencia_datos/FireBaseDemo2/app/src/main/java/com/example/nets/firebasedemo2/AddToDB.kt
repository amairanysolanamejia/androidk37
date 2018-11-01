package com.example.nets.firebasedemo2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class AddToDB: AppCompatActivity() {

    private lateinit var addNewSportTextField: EditText
    private lateinit var addNewSportButton: Button

    private lateinit var database: FirebaseDatabase
    private lateinit var mAuth: FirebaseAuth
    private lateinit var myRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_to_db_layout)

        addNewSportTextField = findViewById(R.id.et_add_new_sport)
        addNewSportButton = findViewById(R.id.button_new_sport)

        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        myRef = database.reference

        myRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot?) {
                var value = p0!!.value
                Log.d(TAG, "Value is: " + value);
            }

            override fun onCancelled(p0: DatabaseError?) {
                Log.w(TAG, "Failed to read value.", p0!!.toException());
            }
        })

        addNewSportButton.setOnClickListener{
            val newSport = addNewSportTextField.text.toString()
            if(!newSport.equals("")){
                val user = mAuth.getCurrentUser()
                val userId = user!!.uid
                Log.d(AddToDB.TAG, userId)
                myRef.child(userId).child("Deportes").child("Deportes Favoritos").child(newSport).setValue("true")
                Toast.makeText(baseContext, "Adding ${newSport} to DB",
                        Toast.LENGTH_SHORT).show()
                addNewSportTextField.setText("")
            }
        }

    }




    companion object {
        private const val TAG = "AddToDB"
    }
}