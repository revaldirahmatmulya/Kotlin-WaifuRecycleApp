package com.example.waifurecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.waifurecycleview.adapter.WaifuAdapter
import com.example.waifurecycleview.model.Waifu

class MainActivity : AppCompatActivity() {
    private lateinit var rvWaifu: RecyclerView
    private val list = ArrayList<Waifu>()

    companion object{
        val INTENT_PARCELABLE = "OBJECT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvWaifu = findViewById(R.id.rv_mywaifu)
        rvWaifu.setHasFixedSize(true)

        list.addAll(getListWaifu())
        showRecyclerList()

    }

    private fun getListWaifu(): ArrayList<Waifu> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataAbout = resources.getStringArray(R.array.data_about)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listWaifu = ArrayList<Waifu>()
        for (i in dataName.indices) {
            val waifu = Waifu(dataName[i], dataDescription[i],dataAbout[i], dataPhoto.getResourceId(i, -1))
            listWaifu.add(waifu)
        }
        return listWaifu
    }

    private fun showRecyclerList() {
        rvWaifu.layoutManager = LinearLayoutManager(this)
        val listWaifuAdapter = WaifuAdapter(list)
        rvWaifu.adapter = listWaifuAdapter
        listWaifuAdapter.setOnItemClickCallback(object : WaifuAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Waifu) {
                showDetailWaifu(data)
            }
        })
    }

    private fun showDetailWaifu(item: Waifu) {
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra(INTENT_PARCELABLE,item)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_profile -> {
                val intent = Intent(this,MyProfileActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}