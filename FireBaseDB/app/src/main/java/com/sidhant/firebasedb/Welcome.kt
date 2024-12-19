package com.sidhant.firebasedb

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Welcome : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val mail=intent.getStringExtra(SignIn.KEY1)
        val name=intent.getStringExtra(SignIn.KEY2)
        val uniqueId=intent.getStringExtra(SignIn.KEY3)

        val congoText=findViewById<TextView>(R.id.textView2)
        val mailText=findViewById<TextView>(R.id.tvMail)
        val idText=findViewById<TextView>(R.id.tvUnique)

        congoText.text="Welcome $name"
        mailText.text="Mail:$mail"
        idText.text="UniqueId:$uniqueId"
    }
}