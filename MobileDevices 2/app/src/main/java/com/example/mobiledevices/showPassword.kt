package com.example.mobiledevices

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class showPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.showpassword)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.show2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val account = findViewById<TextView>(R.id.showAccountonShow)
        val password = findViewById<TextView>(R.id.showPasswordonShow)

        account.text = intent.getStringExtra("account")
        password.text = intent.getStringExtra("password")
    }

    fun backToInput(view: View){
        val intent = Intent(this, inputPassword::class.java)
        startActivity(intent)
    }

    fun nextToMain(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
