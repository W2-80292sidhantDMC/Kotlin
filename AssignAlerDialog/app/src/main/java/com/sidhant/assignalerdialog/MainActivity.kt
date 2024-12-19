package com.sidhant.assignalerdialog

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.sidhant.assignalerdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val options= arrayOf("Java","Kotlin","Python")
            val builder1=AlertDialog.Builder(this)
            builder1.setTitle("which language do you prefer")
            builder1.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialog, which ->

                Toast.makeText(this,"You clicked On${options[which]}",Toast.LENGTH_SHORT).show()

            })

            builder1.setPositiveButton("Submit",DialogInterface.OnClickListener { dialog, which ->

            })
            builder1.setNegativeButton("cancel",DialogInterface.OnClickListener { dialog, which ->

            })
        builder1.show()
        }

        binding.btn2.setOnClickListener {
            val options= arrayOf("Alert Dialog","DatePickerDialog")
            val builder2=AlertDialog.Builder(this)

            builder2.setTitle("What are the Types of DialogBoxes in Android")
            builder2.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this,"You clicked On ${options[which]}",Toast.LENGTH_SHORT).show()
            })

            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInflate, i ->

            })

            builder2.setNegativeButton("Cancel",DialogInterface.OnClickListener { dialogInflate, i ->

            })
            builder2.show()
                }

        binding.btn3.setOnClickListener {
            val options= arrayOf("an operating system","a web browser","a web server")
            val builder3=AlertDialog.Builder(this)

            builder3.setTitle("What is Android ?")
            builder3.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this,"You clicked On ${options[which]} ",Toast.LENGTH_SHORT).show()

            })
            builder3.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInflate, i ->

            })

            builder3.setNegativeButton("Cancel",DialogInterface.OnClickListener { dialogInflate, i ->

            })
            builder3.show()
        }


        binding.btn4.setOnClickListener {
            val builder4=AlertDialog.Builder(this)

            builder4.setTitle("Are you Sure")
            builder4.setMessage("Do you want to close the Exam")

            builder4.setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                finish()
            })
            builder4.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->

            })
            builder4.show()
        }


    }

}