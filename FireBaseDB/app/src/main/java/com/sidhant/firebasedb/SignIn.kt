package com.sidhant.firebasedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignIn : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference

    companion object {
        const val KEY1 = "com.sidhant.firebasedb.SignIn.mail"
        const val KEY2 = "com.sidhant.firebasedb.SignIn.name"
        const val KEY3 = "com.sidhant.firebasedb.SignIn.id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val email = findViewById<EditText>(R.id.etMail)
        val password = findViewById<EditText>(R.id.etPassword)

        val btnsignin = findViewById<Button>(R.id.btnSignIn)

//        database = FirebaseDatabase.getInstance().getReference("Users")

        btnsignin.setOnClickListener {

//            Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show()
//
//            val intent=Intent(this,Welcome::class.java)
//            startActivity(intent)

            val uniqueId = email.text.toString()
           val password = password.text.toString()
            if (uniqueId.isNotEmpty() && password.isNotEmpty()) {
                // Sanitize email to make it compatible with Firebase path
                val sanitizedId = sanitizeEmail(uniqueId)
                readData(sanitizedId)
            } else {
                Toast.makeText(this, "Please enter email and Password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Helper function to sanitize email for Firebase database compatibility
    private fun sanitizeEmail(email: String): String {
        // Replace invalid Firebase path characters
        return email.replace(".", "_").replace("@", "_")
    }

    private fun readData(uniqueId: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(uniqueId).get().addOnSuccessListener {

            if (it.exists()) {

                val email = it.child("email").value
                val name = it.child("name").value
                val uniqueId = it.child("uniqueId").value
                val password=it.child("password").value

                val intent = Intent(this, Welcome::class.java)
                intent.putExtra(KEY1, email.toString())
                intent.putExtra(KEY2, name.toString())
                intent.putExtra(KEY3, uniqueId.toString())

                startActivity(intent)

            } else {
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
}
