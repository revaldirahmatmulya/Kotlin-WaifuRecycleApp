package com.example.waifurecycleview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.waifurecycleview.R
import com.example.waifurecycleview.model.Waifu
import java.util.ArrayList

class WaifuAdapter(private val listWaifu: ArrayList<Waifu>) : RecyclerView.Adapter<WaifuAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_waifu, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, about,description, image) = listWaifu[position]
        holder.imgPhoto.setImageResource(image)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.tvAbout.text = about
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listWaifu[holder.adapterPosition])
        }


    }

    override fun getItemCount(): Int = listWaifu.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAbout: TextView = itemView.findViewById(R.id.tv_waifu_desc)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_waifu)
        val tvName: TextView = itemView.findViewById(R.id.tv_waifu_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_waifu_desc)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Waifu)
    }
}
