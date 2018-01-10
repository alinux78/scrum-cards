package com.example.mihai.scrumcards

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCardClick(view: View) {
        val b = view as Button;

        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SingleCardActivity::class.java)

        val cardValue = b.text.toString();

        randomIntent.putExtra(SingleCardActivity.VALUE, cardValue)

        startActivity(randomIntent)
    }
}
