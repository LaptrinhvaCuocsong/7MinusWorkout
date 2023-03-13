package com.example.a7minusworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    private lateinit var flStartButton: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUIComponents()
    }

    private fun setupUIComponents() {
        flStartButton = findViewById(R.id.flStartButton)
        flStartButton.setOnClickListener {}
    }
}