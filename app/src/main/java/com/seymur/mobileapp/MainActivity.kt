package com.seymur.mobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.seymur.mobileapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val sharedPreferences by lazy {
        getSharedPreferences("UserPrefs", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LoginButton.setOnClickListener {
            val email = binding.loginMail.text.toString().trim()
            val password = binding.loginPassword.text.toString().trim()

            binding.loginMailLayout.error = null
            binding.loginPasswordLayout.error = null

            var isValid = true

            if (!CredentialsManager.isEmailValid(email)) {
                binding.loginMailLayout.error = "Invalid email"
                isValid = false
            }

            if (!CredentialsManager.isPasswordValid(password)) {
                binding.loginPasswordLayout.error = "Invalid password"
                isValid = false
            }

            if (isValid) {
                val registeredEmail = sharedPreferences.getString("email", null)
                val registeredPassword = sharedPreferences.getString("password", null)

                if (email == registeredEmail && password == registeredPassword) {
                    val intent = Intent(this, LoginPage::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Incorrect credentials", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.registerNowTextView.setOnClickListener {
            val intent = Intent(this, RegisterPage::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
