package com.example.MOP_task_asg.OFFline

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.MOP_task_asg.network.DataObject

@Dao
interface Gif_dao {

    @Insert
    suspend  fun insert_gif_data(giphyGifUrl: Giphy_gif_url)


    @Query( " select * from giftable")
    fun get_allurl(): LiveData<List<Giphy_gif_url>>






}