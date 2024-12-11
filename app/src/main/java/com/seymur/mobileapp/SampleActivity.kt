package com.seymur.mobileapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seymur.mobileapp.databinding.ActivitySampleBinding

class SampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySampleBinding
    private var isFragmentA = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Display FragmentA initially
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FragmentA())
            .commit()

        // Set button click listener to toggle fragments
        binding.toggleButton.setOnClickListener {
            val fragment = if (isFragmentA) FragmentB() else FragmentA()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            isFragmentA = !isFragmentA
        }
    }
}
