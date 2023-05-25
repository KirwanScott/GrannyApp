package com.example.grannyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        //  ADDED
        var txtName = findViewById(R.id.txtName) as EditText
        var txtUserName = findViewById(R.id.txtUserName) as EditText
        var txtPassword = findViewById(R.id.txtPassword) as EditText
        var lblAuthOutput = findViewById(R.id.lblAuthOutput) as TextView
        var btnRegister = findViewById(R.id.btnRegister) as Button
        var btnLogin = findViewById(R.id.btnLogin) as Button

        // HARDCODED USER DATA
        var arrName = arrayOf("test", "john", "bob")
        var arrUserName = arrayOf("test@gmail.com", "john@gmail.com", "bob@gmail.com")
        var arrPassword = arrayOf("123", "321", "911")


        // ON-REGISTER
        btnRegister.setOnClickListener()
        {
            var i = 0
            var isUserTaken = false
            lblAuthOutput.setText("")

            while (i < arrUserName.size) {
                if(arrUserName[i] == txtUserName.text.toString())
                {
                    isUserTaken = true
                    lblAuthOutput.setText("Username taken!")
                }
                if(i == arrUserName.size-1 && !isUserTaken){
                    lblAuthOutput.setText("Registration Success, Now login!")
                }
                i++
            }
        }


        // ON-LOGIN
        btnLogin.setOnClickListener()
        {
            var i = 0
            var isLoggedIn = false
            lblAuthOutput.setText("")

            while (i < arrUserName.size) {
                if(arrUserName[i] == txtUserName.text.toString() && arrPassword[i] == txtPassword.text.toString())
                {
                    isLoggedIn = true
                    // REDIRECT
                    val i = Intent(this, HomeActivity::class.java).also{
                        it.putExtra("EXTRA MESSAGE1", txtName.text.toString())
                        it.putExtra("EXTRA MESSAGE2", txtUserName.text.toString())
                    }
                    startActivity(i)
                    // TOAST
                    Toast.makeText(this, "Login Succesful", Toast.LENGTH_SHORT).show()
                }
                if(i == arrUserName.size-1 && !isLoggedIn){
                    lblAuthOutput.setText("Login Failed!")
                }
                i++
            }
        }
    }
}