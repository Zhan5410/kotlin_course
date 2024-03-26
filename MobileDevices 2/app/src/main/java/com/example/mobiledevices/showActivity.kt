package com.example.mobiledevices

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import androidx.activity.enableEdgeToEdge

class showActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_show)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.show)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val classValue = intent.getStringExtra("class")
        val studentNumberValue = intent.getStringExtra("studentNumber")
        val nameValue = intent.getStringExtra("name")

        val showClassTextView = findViewById<TextView>(R.id.showClass)
        val showStudentNumberTextView = findViewById<TextView>(R.id.showStudentNumber)
        val showNameTextView = findViewById<TextView>(R.id.showName)

        showClassTextView.text = classValue
        showStudentNumberTextView.text = studentNumberValue
        showNameTextView.text = nameValue
    }

    fun backMain(view: View){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        //finish()
    }

    fun nextToInput(view: View){
        val intent = Intent(this, inputPassword::class.java)
        startActivity(intent)
    }
}
