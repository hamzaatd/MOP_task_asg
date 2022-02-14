package com.example.MOP_task_asg.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retro_upload_instance {


    companion object {


        val baseURL :String =" http://upload.giphy.com/v1/"




        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }


}