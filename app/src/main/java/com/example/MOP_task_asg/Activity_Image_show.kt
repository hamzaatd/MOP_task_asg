package com.example.MOP_task_asg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_image_show.*

class Activity_Image_show : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_show)

        val intent =intent
        val ss:String = intent.getStringExtra("url").toString()

          Glide.with(this)
            .load(ss)
             .into(big_img)




    }
}