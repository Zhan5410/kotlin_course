package com.example.mobiledevices

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class inputPassword : AppCompatActivity(){
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.inputpassword)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.input)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 獲取根佈局
        val rootLayout = findViewById<View>(R.id.inputview)

        // 為根佈局設置觸摸監聽器
        rootLayout.setOnTouchListener { _, event ->
            // 當用戶點擊 EditText 以外的地方時隱藏鍵盤
            if (event.action == MotionEvent.ACTION_DOWN) {
                val inputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(
                    currentFocus?.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
                // 返回 true 以消耗觸摸事件
                true
            } else {
                // 返回 false 以允許其他觸摸事件進行處理
                false
            }
        }
    }

    fun backToShow(view: View){
        val intent = Intent(this, showActivity::class.java)
        startActivity(intent)
    }

    fun nextToShow(view: View){
        val intent = Intent(this, showPassword::class.java)
        intent.putExtra("account", findViewById<EditText>(R.id.inputAccount).text.toString())
        intent.putExtra("password", findViewById<EditText>(R.id.inputPassword).text.toString())
        startActivity(intent)
    }

}