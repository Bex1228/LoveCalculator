package com.example.lovecalculator.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.remote.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM `love-table`")
    fun getAll(): List<LoveModel>

    @Query("SELECT * FROM `love-table` ORDER BY fname ASC, sname ASC")
    fun getAllSorted(): List<LoveModel>

}