package com.example.waifurecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.waifurecycleview.model.Waifu

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val waifu = intent.getParcelableExtra<Waifu>(MainActivity.INTENT_PARCELABLE)

        val imageWaifuDetail = findViewById<ImageView>(R.id.img_detail_waifu)
        val nameWaifuDetail = findViewById<TextView>(R.id.tv_detail_name)
        val aboutWaifuDetail = findViewById<TextView>(R.id.tv_detail_about)

        imageWaifuDetail.setImageResource(waifu?.image!!)
        nameWaifuDetail.text = waifu.name
        aboutWaifuDetail.text = waifu.description
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}