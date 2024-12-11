package com.seymur.mobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.seymur.mobileapp.databinding.RegisterfragmentBinding

class RegisterPage : AppCompatActivity() {
    private lateinit var binding: RegisterfragmentBinding

    private val registerMailLayout get() = binding.registerMailLayout
    private val registerMail get() = binding.editTextTextEmailAddress
    private val registerPasswordLayout get() = binding.registerPasswordLayout
    private val registerPassword get() = binding.editTextTextPassword
    private val registerButton get() = binding.registerRButton
    private val loginNowTextView get() = binding.loginNowTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterfragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerButton.setOnClickListener {
            val email = registerMail.text.toString()
            val password = registerPassword.text.toString()

            registerMailLayout.error = null
            registerPasswordLayout.error = null

            var isValid = true

            if (!CredentialsManager.isEmailValid(email)) {
                registerMailLayout.error = "Invalid email"
                isValid = false
            }

            if (!CredentialsManager.isPasswordValid(password)) {
                registerPasswordLayout.error = "Invalid password"
                isValid = false
            }

            if (isValid) {
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
        }

        loginNowTextView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
