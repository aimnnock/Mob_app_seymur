package com.seymur.mobileapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seymur.mobileapp.databinding.LoginfragmentBinding
import java.io.File

class LoginPage : AppCompatActivity() {
    private lateinit var binding: LoginfragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginfragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val file = File(filesDir, "x.txt")
        val savedMail = file.readLines().firstOrNull()?.split(":")?.get(0) ?: "Email not found"

        binding.userEmailTextView.text = "Logged in as: $savedMail"


        binding.exitButton.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
