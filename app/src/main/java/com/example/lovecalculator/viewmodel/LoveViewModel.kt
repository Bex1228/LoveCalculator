package com.example.lovecalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.repository.Repository

class LoveViewModel : ViewModel(){

    val repository = Repository()

    fun getLiveLoveData(firstName: String, secondName: String): LiveData<LoveModel>{
        return repository.getData(firstName, secondName)
    }

}