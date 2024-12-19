package com.sidhant.multiscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
//creating key
   companion object{
       const val KEY="com.sidhant.multiscreen.MainActivity.KEY"
   }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView=findViewById<TextView>(R.id.textView)
        val  btnOrder=findViewById<Button>(R.id.btnOrder)
        val eT1=findViewById<EditText>(R.id.eT1)
        val eT2=findViewById<EditText>(R.id.eT2)
        val eT3=findViewById<EditText>(R.id.eT3)
        val eT4=findViewById<EditText>(R.id.eT4)



        btnOrder.setOnClickListener {

            val ordersPlaced=eT1.text.toString() + " " + eT2.text.toString() + " "+
                    eT3.text.toString() + " " + eT4.text.toString()

intent=Intent(this,Order::class.java)
            intent.putExtra(KEY,ordersPlaced)
            startActivity(intent)
        }
    }
}