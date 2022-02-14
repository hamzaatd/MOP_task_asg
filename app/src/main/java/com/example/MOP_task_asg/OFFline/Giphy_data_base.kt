package com.example.MOP_task_asg.OFFline

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.MOP_task_asg.network.DataObject


@Database(entities = [Giphy_gif_url::class],version = 1)
abstract class Giphy_data_base: RoomDatabase() {


     abstract fun gif_dao() :Gif_dao

companion object {
     @Volatile
     private  var instance : Giphy_data_base ? =null

     fun getdatabase_instance(context: Context):Giphy_data_base?
     {

          if(instance == null)
          {
            synchronized(this){
             instance = Room.databaseBuilder(context.applicationContext,Giphy_data_base::class.java,"giphydb").build()
            }

          }

          return instance


     }








}}




