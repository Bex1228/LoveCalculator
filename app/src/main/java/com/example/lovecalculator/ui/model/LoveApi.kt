package com.example.lovecalculator.ui.model

import com.example.lovecalculator.ui.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    //https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John
    @GET("getPercentage")
    fun getLove(
        @Query("sname") secondName: String,
        @Query("fname") firstName: String,
        @Header("X-RapidAPI-Key") key: String = "61c3c88164msh3f8c2d2c14c4e13p1cf2d0jsn9e9577da29a7",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}