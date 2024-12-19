package com.sidhant.firebasedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val signButton = findViewById<Button>(R.id.btnSignUp)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etMail = findViewById<TextInputEditText>(R.id.etMail)
        val userId = findViewById<TextInputEditText>(R.id.etUserName)
        val userPassword = findViewById<TextInputEditText>(R.id.etPassword)

        val textview=findViewById<TextView>(R.id.textView)

        textview.setOnClickListener{
            val intent=Intent(this,SignIn::class.java)
            startActivity(intent)
        }

        database = FirebaseDatabase.getInstance().getReference("Users")


        signButton.setOnClickListener {
            val name = etName.text.toString().trim()
            val mail = etMail.text.toString().trim()
            val uniqueId = userId.text.toString().trim()
            val password = userPassword.text.toString().trim()

            // Input validation
            if (name.isEmpty() || mail.isEmpty() || uniqueId.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val user = User(name, mail, password, uniqueId)

            // Save user in Firebase
            database.child(uniqueId).setValue(user)
                .addOnSuccessListener {
                    Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show()
                    etName.text?.clear()
                    etMail.text?.clear()
                    userId.text?.clear()
                    userPassword.text?.clear()
                }
                .addOnFailureListener { error ->
                    Toast.makeText(this, "Registration Failed: ${error.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
