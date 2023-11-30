package com.example.lovecalculator.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.remote.LoveApi
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api : LoveApi) {

    fun getData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val love = MutableLiveData<LoveModel>()
        api.getLove(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    love.postValue(response.body())
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message} ")
                }
            })
        return love
    }
}