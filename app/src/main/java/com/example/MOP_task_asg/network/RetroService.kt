package com.example.MOP_task_asg.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RetroService {

/*
    @GET("character")
    suspend fun getDataFromAPI(@Query("page") query: Int):RickAndMortyList

 */



    @GET("gifs/trending?api_key=xCK3sN3tiWhMw8SrhczeDn8FSV09MSR4")
    suspend fun  get_alltrending_images(@Query("offset") page_number :Int) : DataResult

    @GET("gifs/search?api_key=xCK3sN3tiWhMw8SrhczeDn8FSV09MSR4")
    suspend fun  search_alltrending_images(@Query("q") search: String ,@Query("offset") page_number: Int) : DataResult

    @FormUrlEncoded
    @POST("gifs?api_key=xCK3sN3tiWhMw8SrhczeDn8FSV09MSR4")
     fun upload_into_giphy(@Field("file") url :String) :Call<DataObject>






   // http://upload.giphy.com/v1/gifs?api_key=xCK3sN3tiWhMw8SrhczeDn8FSV09MSR4&source_image_url=https://www.w3schools.com/images/lamp.jpg


}