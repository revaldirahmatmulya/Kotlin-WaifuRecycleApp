package com.example.waifurecycleview.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Waifu(
    val name: String,
    val about: String,
    val description: String,
    val image: Int
) : Parcelable
