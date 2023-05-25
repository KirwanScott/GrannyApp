package com.example.grannyapp

import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        // GET USER-INFO
        var name_passed = intent.getStringExtra("EXTRA MESSAGE1")
        var userName_passed = intent.getStringExtra("EXTRA MESSAGE2")

        // DISPLAY USER-INFO
        var lblName = findViewById<TextView>(R.id.lblName).apply{
            text = "Name: "+name_passed.toString()
        }
        var lblUserName = findViewById<TextView>(R.id.lblUserName).apply{
            text = "UserName: "+userName_passed.toString()
        }

        var btnBack = findViewById(R.id.btnBack) as Button


        // CLICK->BACK
        btnBack.setOnClickListener()
        {
            // REDIRECT
            val i = Intent(this, MainActivity::class.java);startActivity(i)
            // TOAST
            Toast.makeText(this, "Back to login page", Toast.LENGTH_SHORT).show()
        }
    }
}