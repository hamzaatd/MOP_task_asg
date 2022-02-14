package com.example.MOP_task_asg.OFFline

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "giftable")
data class Giphy_gif_url(
    val url :String

)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int =0











}