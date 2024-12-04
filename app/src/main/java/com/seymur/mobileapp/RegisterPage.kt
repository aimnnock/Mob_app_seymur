package com.seymur.mobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.seymur.mobileapp.databinding.RegisterfragmentBinding

class RegisterPage : AppCompatActivity() {
    private lateinit var binding: RegisterfragmentBinding


    private val sharedPreferences by lazy {
        getSharedPreferences("UserPrefs", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterfragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerRButton.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString().trim()
            val password = binding.editTextTextPassword.text.toString().trim()

            binding.registerMailLayout.error = null
            binding.registerPasswordLayout.error = null

            var isValid = true

            if (!CredentialsManager.isEmailValid(email)) {
                binding.registerMailLayout.error = "Invalid email"
                isValid = false
            }

            if (!CredentialsManager.isPasswordValid(password)) {
                binding.registerPasswordLayout.error = "Invalid password"
                isValid = false
            }

            if (isValid) {

                with(sharedPreferences.edit()) {
                    putString("email", email)
                    putString("password", password)
                    apply()
                }
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_LONG).show()


                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
        }

        binding.loginNowTextView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
