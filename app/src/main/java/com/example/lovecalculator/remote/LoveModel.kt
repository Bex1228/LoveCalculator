package com.example.lovecalculator.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity("love-table")
data class LoveModel(
    @SerializedName("sname")
    val sName: String,
    @SerializedName("fname")
    val fName: String,
    val percentage: String,
    val result: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
) : Serializable {
    override fun toString(): String {
        return "$percentage \n $fName \n $sName \n $result \n\n"
    }
}
