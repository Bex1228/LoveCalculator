package com.example.lovecalculator.ui

import com.example.lovecalculator.ui.model.LoveModel
import com.example.lovecalculator.ui.model.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(private val loveView: LoveView) {

    val api = RetrofitService.api

    fun getLove(firstName: String, secondName: String) {
        api.getLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    val loveModel = response.body()
                    loveModel?.let {
                        loveView.showResponse(loveModel)
                    } ?: loveView.showError("Error: Body is null")
                } else {
                    loveView.showError("Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                loveView.showError(t.message.toString())
            }

        })
    }
}