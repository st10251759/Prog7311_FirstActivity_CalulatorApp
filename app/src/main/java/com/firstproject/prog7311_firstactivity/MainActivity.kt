package com.firstproject.prog7311_firstactivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnOne: Button
    private lateinit var etValOne: EditText
    private lateinit var etValTwo: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        btnOne = findViewById(R.id.buttonAdd)
        etValOne = findViewById(R.id.etValOne)
        etValTwo = findViewById(R.id.etValTwo)
        tvResult = findViewById(R.id.tvResult)

        // Set click listener for the button
        btnOne.setOnClickListener {
            // Get the input values from EditText fields
            val valueOne = etValOne.text.toString()
            val valueTwo = etValTwo.text.toString()

            // Check if the input values are not empty
            if (valueOne.isNotEmpty() && valueTwo.isNotEmpty()) {
                // Convert the input values to numbers
                val numOne = valueOne.toDouble()
                val numTwo = valueTwo.toDouble()

                // Add the numbers
                val result = numOne + numTwo

                // Display the result in the TextView
                tvResult.text = "Result: $result"
            } else {
                // Show a toast message if any of the fields are empty
                Toast.makeText(this, "Please enter both values", Toast.LENGTH_SHORT).show()
            }
        }
    }
}