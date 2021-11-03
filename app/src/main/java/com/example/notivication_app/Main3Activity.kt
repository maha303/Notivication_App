package com.example.notivication_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notivication_app.databinding.ActivityMain3Binding

class Main3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val b1=ActivityMain3Binding.inflate(layoutInflater)
        setContentView(b1.root)
    }
}