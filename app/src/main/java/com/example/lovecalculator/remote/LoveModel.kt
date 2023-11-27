package com.example.lovecalculator.remote

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoveModel(
    @SerializedName("sname")
    val sName: String,
    @SerializedName("fname")
    val fName: String,
    val percentage: String,
    val result: String,
) : Serializable
