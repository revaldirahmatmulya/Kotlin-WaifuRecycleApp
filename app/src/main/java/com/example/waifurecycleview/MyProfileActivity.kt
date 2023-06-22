package com.example.waifurecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MyProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val myName = findViewById<TextView>(R.id.tv_name)
        val myEmail = findViewById<TextView>(R.id.tv_email)
        val myPhoto = findViewById<ImageView>(R.id.img_profile)

        myName.text = resources.getString(R.string.my_name)
        myEmail.text = resources.getString(R.string.my_email)
        myPhoto.setImageResource(R.drawable.revaldi)


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}