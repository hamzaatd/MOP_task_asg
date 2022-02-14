package com.example.MOP_task_asg

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.media.session.MediaSession
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.MOP_task_asg.network.DataObject
import com.example.MOP_task_asg.network.RetroInstance
import com.example.MOP_task_asg.network.RetroService
import com.example.MOP_task_asg.network.Retro_upload_instance
import kotlinx.android.synthetic.main.activity_video_upload.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream


var base_64_string :String = ""
var uri:Uri? =null
var mediaController :MediaController? =null

class Video_upload_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_upload)

        val retroService = Retro_upload_instance.getRetroInstance().create(RetroService::class.java)

        choose.setOnClickListener({

            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    101
                )


            } else {

                select_video()


            }


        })

        upload.setOnClickListener({

            if(!base_64_string.isEmpty()) {

                val result = retroService.upload_into_giphy(base_64_string)
                result.enqueue(object : Callback<DataObject> {
                    override fun onResponse(
                        call: Call<DataObject>,
                        response: Response<DataObject>
                    ) {
                        if (response.isSuccessful) {
                            Toast.makeText(this@Video_upload_activity, "success", Toast.LENGTH_LONG)
                                .show()
                        } else {

                            Toast.makeText(
                                this@Video_upload_activity,
                                " :" + response.message(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<DataObject>, t: Throwable) {
                        Toast.makeText(
                            this@Video_upload_activity,
                            "" + t.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }


                })
            }
            else{

          Toast.makeText(this,"provide data",Toast.LENGTH_LONG).show()


            }})







        }














    private fun select_video() {

        val intent =Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("video/mp4")
        startActivityForResult(Intent.createChooser(intent,""),100)
            }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 101 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            select_video()
        }
        else{
            Toast.makeText(this,"required permission",Toast.LENGTH_LONG).show()

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100 && resultCode == RESULT_OK && data!=null)
        {
           uri = data.data

            if (uri != null) {

             open_video(uri!!)

          base_64_string =  encode_video(uri!!)

            }


        }



    }







    fun encode_video(selectedVideoUri :Uri):String {


        var inputStream: InputStream? = null
        // Converting the video in to the bytes


        try {
            inputStream = contentResolver.openInputStream(selectedVideoUri)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        val bufferSize = 1024*5
        val buffer = ByteArray(bufferSize)
        val byteBuffer = ByteArrayOutputStream()
        var len = 0
        try {
            while (inputStream!!.read(buffer).also { len = it } != -1) {
                byteBuffer.write(buffer, 0, len)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        println("converted!")
        var videoData = ""
        //Converting bytes into base64
        videoData = Base64.encodeToString(byteBuffer.toByteArray(), Base64.DEFAULT)
        Log.d("VideoData**>  ", videoData)
        val sinSaltoFinal2 = videoData.trim { it <= ' ' }
        val sinsinSalto2 = sinSaltoFinal2.replace("\n".toRegex(), "")
        Log.d("VideoData**>  ", sinsinSalto2)
        val baseVideo = sinsinSalto2

        return  baseVideo
    }




    fun open_video(uri: Uri){

      val mediaController =MediaController(this)
        mediaController.setMediaPlayer(video)
        video.setMediaController(mediaController)

         if(uri!=null)
        {
            video.setVideoURI(uri);
            video.requestFocus();
            video.start();
        }
   }











}