package com.example.lovecalculator.ui

import com.example.lovecalculator.ui.model.LoveModel

interface LoveView {
    fun showResponse(loveModel: LoveModel)
    fun showError(error: String)
}