package com.example.MOP_task_asg.network

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class DataResult(
    @SerializedName("data")
    val res :List<DataObject>
)


data class DataObject(

     @SerializedName("images")
     val images:DataImage

)

data class DataImage(
    @SerializedName("original")
    val ogImage: ogImage

)

data class ogImage(
    val url:String
)

