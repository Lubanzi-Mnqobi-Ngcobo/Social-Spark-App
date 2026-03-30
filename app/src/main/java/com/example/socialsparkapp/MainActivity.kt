package com.example.socialsparkapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val edtTimeOfDay = findViewById<EditText>(R.id.edtTimeOfDay)
        val ansBubble = findViewById<TextView>(R.id.ansBubble)

        btnSuggest. setOnClickListener {
            // Once the user input is in, fetch it and clean it up
            val input = edtTimeOfDay.text.toString().lowercase().trim()

            // Log the input for debugging
            Log.d("Social Spark", " User input: $input")


            // Determine suggestion based on input
             val result = when (input) {
                "morning" -> "Send a 'Good Morning' text to a family member"
                "mid-morning" -> "Reach out to a colleague with a quick 'Thank You'"
                "afternoon" -> "Share a funny meme or interesting link with a friend"
                "dinner" -> "Call a friend or relative for a 5-minute catch-up"
                "night" -> "Leave a thoughtful comment on a friend's post"
                else -> "Nice Attempt, Please try again with suggestions :) (morning, mid-morning, afternoon snack time, afternoon, dinner, night)"
            }

            // Log the reult
            Log.d("Social Spark", "Suggestion result: $result")

            // Display the result
            ansBubble.text = result
        }

        btnReset.setOnClickListener {
            // Clear the input and output
            edtTimeOfDay.text.clear()
            ansBubble.text = ""
        }

    }
}