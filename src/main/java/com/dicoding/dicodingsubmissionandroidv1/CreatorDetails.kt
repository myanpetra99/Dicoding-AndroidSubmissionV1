package com.dicoding.dicodingsubmissionandroidv1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreatorDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creator_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvProfileName : TextView = findViewById(R.id.tv_profile_name)
        val tvProfileEmail : TextView = findViewById(R.id.tv_profile_email)

        tvProfileName.text = "Michael Yan Petra Sembiring"
        tvProfileEmail.text = "mypdota99@gmail.com"
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}

